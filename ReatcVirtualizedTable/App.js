import React from 'react';
import {
  MultiGrid,
  AutoSizer,
  CellMeasurer,
  CellMeasurerCache
} from 'react-virtualized';
import { Resizable } from 'react-resizable';
import _ from 'lodash';

import 'antd/dist/antd.css';
import './App.css';
import './style.css';

if (!String.prototype.replaceAll) {
  /* for-support IE */
  /* https://vanillajstoolkit.com/polyfills/stringreplaceall/ */
  String.prototype.replaceAll = function (str, newStr) {
    if (Object.prototype.toString.call(str).toLowerCase() === '[object regexp]') {
      return this.replace(str, newStr);
    }
    return this.replace(new RegExp(str, 'g'), newStr);
  };
}

const topStyle = {
  backgroundColor: '#3B9BFA',
  color: 'white'
};

const DEFAULT_WIDTH = 160;
const ROW_HEIGHT = 64;
let countIndex = 0;
function genKey() {
  countIndex += 1;
  return countIndex;
}

class VirtualGrid extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      columns: [],
      data: [],
      sortBy: null,
      sortOrder: 'asc',
      inputSelectValue: '',
      openSearchOutlined: false,
    };

    this.grid = React.createRef();
    this.cellRenderer = this.cellRenderer.bind(this);
    this.dataRenderer = this.dataRenderer.bind(this);
    this.headerRenderer = this.headerRenderer.bind(this);
    this.getWidth = this.getWidth.bind(this);

    this._cache = new CellMeasurerCache({
      fixedHeight: true
    });
  }

  componentDidMount() {
    const columns = this.props.columns.map(c => {
      if (c.width) {
        return c;
      }
      return { ...c, width: DEFAULT_WIDTH };
    });
    let data = _.cloneDeep(this.props.data);

    /* 實做 filter 功能 */
    let searchInputText = this.props.searchInputText;
    searchInputText = searchInputText.toLowerCase();
    if (this.props.searchInputText !== '') {
      const resultData = data.filter((element) => {
        /* 物件轉出內部所有key組成的 key陣列 */
        const elementKeyArray = Object.keys(element);

        let isTarget = false;
        for (let i = 0, len = elementKeyArray.length; i < len; i++) {
          const key = elementKeyArray[i];
          let elementValue = element[key];
          elementValue = String(elementValue).toString();
          elementValue = elementValue.toLowerCase();
          if (elementValue.indexOf(searchInputText) !== -1) {
            isTarget = true;
            element[key] = elementValue.replaceAll(searchInputText, '<search-input-text>' + searchInputText + '</search-input-text>');
          }
        }

        if (isTarget === false) {
          return null;
        }
        return element;
      });
      data = resultData;
    }

    this.setState({
      columns,
      data
    });
  }

  dataRenderer = (attr) => {
    if (attr.rowIndex === 0) {
      /* table > thead > tr > th */
      return this.headerRenderer(attr);
    }
    /* table > tbody > tr > td */
    return this.cellRenderer(attr);
  };

  /* table > tbody > tr > td 每個單元格 的繪製 */
  cellRenderer = (cellRenderInput) => {
    let { columnIndex, key, parent, rowIndex, style } = cellRenderInput;

    const { columns } = this.props;
    const { data } = this.state;
    const row = data[rowIndex - 1];
    const col = columns[columnIndex];

    let content = row[col.dataIndex];
    if (col.render) {
      content = col.render(content, row);
    }

    content = String(content).toString();
    /* 這個 resultArray陣列 會儲存重要資訊， */
    /* 如果是必須標註為黃色背景的『搜尋字』isTarget為true */
    /* 如果非『搜尋字』則isTarget為false */
    let str = JSON.parse(JSON.stringify(content));
    let resultArray = [];
    let startIndex = 0;
    let endIndex = 0;
    let needTailStr = false;
    while (true) {
      if (str.indexOf("<search-input-text>") === -1) {
        break;
      }
      needTailStr = true;
      startIndex = str.indexOf("<search-input-text>");
      endIndex = str.indexOf("</search-input-text>");

      resultArray.push({
        isTarget: false,
        value: str.substring(0, startIndex),
      });

      resultArray.push({
        isTarget: true,
        value: str.substring(startIndex, endIndex),
      });

      if (str.indexOf("</search-input-text>") === -1) {
        break;
      }
      /* 接著把前面處理過的字串cut移除掉。下一輪迴圈就跑去處理 下一個 search-input-text 包起來的『搜尋關鍵字』。 */
      let cutIndex = str.indexOf("</search-input-text>") + 20;
      str = str.substring(cutIndex, str.length);
    }

    if (str !== '' && needTailStr === true) {
      /* 塞入字串最後的結尾 */
      resultArray.push({
        isTarget: true,
        value: str,
      });
    } else {
      resultArray.push({
        isTarget: false,
        value: str,
      });
    }

    /* 進行修正，把 <search-input-text>標注拿掉，把『非搜尋字』的 isTarget 重設回 false */
    resultArray = resultArray.map((element) => {
      if (element.value.indexOf('<search-input-text>') !== -1) {
        element.isTarget = true;
        element.value = element.value.replace('<search-input-text>', '');
      } else {
        element.isTarget = false;
      }
      return element;
    });

    return (
      <CellMeasurer
        cache={this._cache}
        columnIndex={columnIndex}
        key={key}
        parent={parent}
        rowIndex={rowIndex}
      >
        <div
          style={{
            ...style,
            border: '1px solid gray',
            whiteSpace: 'pre',
            backgroundColor: rowIndex % 2 === 0 ? '#E8F4FF' : 'white',
            width: '100%',
            resize: 'none',
            overflow: 'auto',
            fontSize: '16px',
          }}>
          {
            resultArray.map((element) => {
              if (element.isTarget === true) {
                /* 黃色背景提示『搜尋字』 */
                return (<span key={genKey()} style={{ backgroundColor: '#F9F900' }}>{element.value}</span>);
              }
              return (<span key={genKey()}>{element.value}</span>);
            })
          }
        </div>
      </CellMeasurer>
    );
  };

  /* table > thead > tr > th 每個標頭 的繪製 */
  headerRenderer = ({ columnIndex, key, style }) => {
    const { columns, sortBy, sortOrder } = this.state;
    const col = columns[columnIndex];
    const handle = (
      <span className='resize-handle' onClick={e => e.stopPropagation()} />
    );

    const handleResize = (event, { size }) => {
      this.setState({
        columns: columns.map((c, index) => {
          if (index === columnIndex) {
            const { width } = size;
            return { ...c, width };
          }
          return c;
        })
      });
      if (this.grid.current) {
        this.grid.current.recomputeGridSize({});
      }
    };

    const handleSort = () => {
      const sortFunc = (e1, e2) =>
        col.sort(e1[col.dataIndex], e2[col.dataIndex]);
      if (col.sort) {
        const { data } = this.state;
        if (!sortBy) {
          const newData = _.cloneDeep(data).sort(sortFunc);
          this.setState({
            data: newData,
            sortBy: col.dataIndex,
            sortOrder: 'asc'
          });
        } else if (sortBy === col.dataIndex && sortOrder === 'asc') {
          const newData = _.cloneDeep(data)
            .sort(sortFunc)
            .reverse();
          this.setState({
            data: newData,
            sortBy: col.dataIndex,
            sortOrder: 'desc'
          });
        } else {
          const newData = _.cloneDeep(this.props.data);
          this.setState({ data: newData, sortBy: null, sortOrder: 'asc' });
          this.props.handleClearOnClick();
        }
      }
    };

    return (
      <Resizable
        width={col.width}
        height={0}
        handle={handle}
        onResize={handleResize}
        key={key}
        style={style}
      >
        <div
          style={{
            ...style,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            cursor: col.sort ? 'pointer' : 'auto',
          }}
          key={key}
          onClick={handleSort}
        >
          <span style={{ fontSize: '20px' }}>
            {col.title}
          </span>
          {
            (sortBy === col.dataIndex) ? (
              (sortOrder === 'asc') ? (
                /* <span style={{ position: 'absolute', right: 42 }}>&#9650;</span> */
                <span style={{ position: 'absolute', right: 5, fontSize: '32px' }}>↑</span>
              ) : (
                /* <span style={{ position: 'absolute', right: 42 }}>&#9660;</span> */
                <span style={{ position: 'absolute', right: 5, fontSize: '32px' }}>↓</span>
              )
            ) : (null)
          }
        </div>
      </Resizable>
    );
  };

  getWidth = (totalWidth, height, index) => {
    const { columns, data, rowHeight } = this.props;
    const col = columns[index];
    if (col.width) {
      return col.width;
    }
    const noWidthColumns = columns.filter(c => !c.width);
    const fixedWidth = columns.reduce((a, c) => a + (c?.width || 0), 0);
    let w = Math.floor((totalWidth - fixedWidth) / noWidthColumns.length);
    if (data.length * rowHeight > height && index === columns.length - 1) {
      w -= 20;
    }
    return w;
  };

  render() {
    const { rowHeight, fixedColumnCount } = this.props;
    const { columns, data } = this.state;
    return (
      <div style={{ height: '100%' }}>
        <AutoSizer>
          {({ width, height }) => (
            <MultiGrid
              ref={this.grid}
              columnWidth={({ index }) => columns[index]?.width || 0}
              columnCount={columns.length}
              height={height}
              width={width}
              rowHeight={rowHeight}
              rowCount={data.length + 1}
              estimatedRowSize={rowHeight}
              cellRenderer={this.dataRenderer}
              fixedRowCount={1}
              fixedColumnCount={fixedColumnCount}
              hideTopRightGridScrollbar
              hideBottomLeftGridScrollbar
              enableFixedColumnScroll
              enableFixedRowScroll
              style={{ border: '1px solid lightgray' }}
              styleTopLeftGrid={{
                ...topStyle
              }}
              styleTopRightGrid={{
                ...topStyle
              }}
              styleBottomLeftGrid={{}}
              styleBottomRightGrid={{}}
            />
          )}
        </AutoSizer>
      </div>
    );
  }
}

function getStableSort(a, b) {
  if (a === null || a === undefined) {
    a = '';
  }
  if (b === null || b === undefined) {
    b = '';
  }
  if ((typeof a) === 'number' && (typeof b) === 'number') {
    /* 數字排序 */
    return (a - b);
  }
  /* 字串排序 */
  a = String(a).toString();
  b = String(b).toString();
  return a.localeCompare(b);
}

let columns = [
  { key: '姓名', title: '姓名', dataIndex: 'name', width: 200, sort: getStableSort },
  { key: '說明', title: '說明', dataIndex: 'description', width: 200, sort: getStableSort },
  { key: 'Id', title: 'Id', dataIndex: 'id', width: 200, sort: getStableSort }
];

let data = [
  {
    name: '丘比\nQ比\n?????\nKyuubee\n',
    description: '【孵化器】\n【Incubator】\n自稱「魔法的使者」，\n' +
      '宛如吉祥物的四足步行動物。\n沒有性別。\n真面目是孵化器，\n外星生命的終端。\n' +
      '除了自己選定的人，\n無法被其他人看見，\n可透過心靈感應與特定對象溝通。\n' +
      '基本上沒有表情，\n除進食外皆不張口。\n能以實現任一願望的代價，\n' +
      '將少女的靈魂製成 靈魂寶石【soul gem】。\n使命是交換魔法少女的「契約」，\n' +
      '也負責回收 悲嘆之種【grief seed】。\n' +
      '透過從旁說明、構築多人心靈感應等方式，\n對魔法少女提供必要協助。\n',
    id: -1
  },
  { name: '環彩羽', description: '屬性：光、類型：治癒、初始：1星', id: 1 },
  { name: '七海八千代', description: '屬性：水、類型：平衡、初始：2星', id: 2 },
  { name: '由比鶴乃', description: '屬性：火、類型：魔法、初始：2星', id: 3 },
  { name: '深月菲莉西亞', description: '屬性：闇、類型：攻擊、初始：2星', id: 4 },
  { name: '二葉紗奈', description: '屬性：木、類型：防禦、初始：2星', id: 5 },
  { name: '環羽衣', description: '屬性：闇、類型：平衡、初始：4星', id: 6 },
  { name: '十咎桃子', description: '屬性：火、類型：平衡、初始：4星', id: 7 },
  { name: '秋野楓', description: '屬性：木、類型：魔法、初始：3星', id: 8 },
  { name: '水波玲奈', description: '屬性：水、類型：攻擊、初始：4星', id: 9 },
  { name: '阿莉娜·格雷', description: '屬性：木、類型：攻擊、初始：4星', id: 10 },
  { name: '里見燈花', description: '屬性：火、類型：魔法、初始：4星', id: 11 },
  { name: '柊音夢', description: '屬性：木、類型：支援、初始：4星', id: 12 },
  { name: '梓美冬', description: '屬性：闇、類型：支援、初始：4星', id: 13 },
  { name: '天音月夜、明槻月夜', description: '屬性：闇、類型：平衡、初始：4星', id: 14 },
  { name: '天音月?', description: '屬性：光、類型：魔法、初始：4星', id: 15 },
  { name: '觀鳥令', description: '屬性：火、類型：攻擊、初始：3星', id: 16 },
  { name: '牧野郁美', description: '屬性：闇、類型：治療、初始：4星', id: 17 },
  { name: '黑江', description: '屬性：？、類型：？、初始：？星', id: 18 },
  {
    name: '八雲美玉',
    description: '屬性：無、類型：支援、初始：4星\n在神濱市經營「調整屋」的魔法少女\n' +
      '通過魔力的調整服務和銷售商品賺取 悲嘆之種【grief seed】，\n很少參與戰鬥。\n' +
      '平常輕鬆愉快地待人接物，\n而了解她的經歷的魔法少女甚少。\n',
    id: 19
  },
  { name: '藍家姬奈', description: '屬性：？、類型：？、初始：？星', id: 20 },
  { name: '宮尾時雨', description: '屬性：木、類型：支援、初始：4星', id: 21 },
  { name: '安積育夢', description: '屬性：火、類型：攻擊、初始：4星', id: 22 },
  { name: '神樂燦', description: '屬性：？、類型：？、初始：？星', id: 23 },
  { name: '雪野加奈惠', description: '屬性：闇、類型：平衡、初始：4星', id: 24 },
  { name: '安名梅露', description: '屬性：木、類型：支援、初始：3星', id: 25 },
  { name: '和泉十七夜', description: '屬性：光、類型：攻擊、初始：4星', id: 26 },
  { name: '萬年櫻的謠言\n柊櫻子', description: '屬性：光、類型：平衡、初始：4星', id: 27 },
  { name: '都雛乃', description: '屬性：木、類型：支援、初始：2星', id: 28 },
  { name: '御園花凜', description: '屬性：火、類型：支援、初始：4星', id: 29 },
  { name: '八雲美影', description: '屬性：？、類型：？、初始：？星', id: 30 },
  { name: '鹿目圓', description: '屬性：光、類型：治癒、初始：4星', id: 31 },
  { name: '曉美焰', description: '屬性：闇、類型：支援、初始：4星', id: 32 },
  { name: '美樹沙耶香', description: '屬性：水、類型：防禦、初始：4星', id: 33 },
  { name: '巴麻美', description: '屬性：木、類型：魔法、初始：4星', id: 34 },
  { name: '佐倉杏子', description: '屬性：火、類型：攻擊、初始：4星', id: 35 },
  { name: '時女靜香', description: '屬性：？、類型：？、初始：？星', id: 36 },
  { name: '廣江千春', description: '屬性：木、類型：防禦、初始：4星', id: 37 },
  { name: '土岐沙緒', description: '屬性：水、類型：治癒、初始：4星', id: 38 },
  { name: '南津涼子', description: '屬性：火、類型：平衡、初始：4星', id: 39 }
];

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.searchInput = React.createRef();
    this.handleSearchOnClick = this.handleSearchOnClick.bind(this);
    this.handleClearOnClick = this.handleClearOnClick.bind(this);
    this.state = {
      inputSearchValue: '',
    }
  }

  handleSearchOnClick() {
    let inputSearchValue = this.searchInput.current.value;
    inputSearchValue = inputSearchValue.trim();
    this.setState({
      inputSearchValue
    });
  }

  handleClearOnClick() {
    this.searchInput.current.value = '';
    this.setState({
      inputSearchValue: '',
    });
  }

  render() {
    let dashboardId = 12;
    let displayboxId = 34;
    return (
      <div
        style={{
          height: '360px',
          width: '800px',
          display: 'inline-flex',
          flexDirection: 'column',
        }}
      >
        <div
          style={{
            display: 'flex',
            width: '100%',
            flexDirection: 'row-reverse',
          }}
        >
          {/* flexDirection: 'row-reverse' 水平逆向排列 */}
          <input
            type="button"
            value="Clear"
            className="button clear-button"
            onClick={this.handleClearOnClick}
          />
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input
            type="button"
            value="Search"
            className="button search-button"
            onClick={this.handleSearchOnClick}
          />
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input
            ref={this.searchInput}
            type="text"
            style={{
              border: '1px',
              borderBottomStyle: 'solid',
              borderTopStyle: 'none',
              borderLeftStyle: 'none',
              borderRightStyle: 'none',
              backgroundColor: '#F0F0F0',
            }}
          />
        </div>
        <VirtualGrid
          key={`${dashboardId}-${displayboxId}-${this.state.inputSearchValue}`}
          columns={columns}
          rowHeight={ROW_HEIGHT}
          data={data}
          searchInputText={this.state.inputSearchValue}
          fixedColumnCount={0}
          handleClearOnClick={this.handleClearOnClick}
        />
      </div>
    );
  }
}
