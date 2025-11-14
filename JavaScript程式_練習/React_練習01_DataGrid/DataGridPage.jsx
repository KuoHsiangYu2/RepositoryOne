import React, { useState, useMemo, useEffect } from "react";
import "./DataGridPage.css";
import apiService from "./service/dataGridService"; /* apiService 是自行客製化命名 */

function DataGridPage() {

  const [tableHeader, setTableHeader] = useState([]); // table header.
  const [tableBody, setTableBody] = useState([]); // table body.

  const [searchText, setSearchText] = useState(""); // 搜尋.
  const [sortConfig, setSortConfig] = useState({ key: null, direction: "asc" }); // 排序.
  const [currentPage, setCurrentPage] = useState(1); // 第幾頁.
  const [rowsPerPage, setRowsPerPage] = useState(5); // 多少筆資料做分頁.

  useEffect(() => {
    /* 當 元件 render 完畢時，fetch data 打後端 Web API 抓取資料 */
    console.log("#1 mounted data");

    // fetch data.
    const tempTableHeader = apiService.getTableHeader();
    const tempTableBody = apiService.getTableBody();

    console.log("tempTableHeader ", tempTableHeader);
    console.log("tempTableBody ", tempTableBody);

    setTableHeader(tempTableHeader);
    setTableBody(tempTableBody);

    return () => {
      /* 當元件卸載時清除 */
      console.log("#2 unmounted _ ");
    };
  }, []);

  // 搜尋功能.
  const filteredData = useMemo(() => {
    return tableBody.filter((row) =>
      row.title.toLowerCase().includes(searchText.toLowerCase())
    );
  }, [searchText, tableBody]);

  // 排序功能.
  const sortedData = useMemo(() => {
    if (!sortConfig.key) {
      // key 為 null ，則無排序。.
      return filteredData;
    }

    const sorted = [...filteredData].sort((a, b) => {
      if (a[sortConfig.key] < b[sortConfig.key]) {
        return (sortConfig.direction === "asc") ? -1 : 1;
      }
      if (a[sortConfig.key] > b[sortConfig.key]) {
        return (sortConfig.direction === "asc") ? 1 : -1;
      }
      return 0;
    });
    return sorted;
  }, [filteredData, sortConfig]);

  // 使用者點擊，啟動排序功能。.
  function requestSort(hKey) {
    // asc 從小排到大.
    // desc 從大排到小.
    let direction = "asc";
    if (sortConfig.key === hKey && sortConfig.direction === "asc") {
      // asc 再按一次，進入 desc排序狀態.
      direction = "desc";
    }
    if (sortConfig.key === hKey && sortConfig.direction === "desc") {
      // desc 再按一次解除排序.
      hKey = null;
      direction = "asc";
    }
    setSortConfig({
      key: hKey,
      direction: direction
    });
  };

  // 分頁功能.
  // 計算總共幾頁.
  const totalPages = Math.ceil(sortedData.length / rowsPerPage);

  /* 取出某一頁的指定筆數 sortedData.slice(起始值, 終止值) */
  const pagedData = sortedData.slice(((currentPage - 1) * rowsPerPage), (currentPage * rowsPerPage));

  function handlePageChange(page) {
    if ((page >= 1) && (page <= totalPages)) {
      setCurrentPage(page);
    }
  };

  // 本地化價格標註，標註新台幣。.
  function getPrice(price) {
    return `${price} NT`;
  };

  // sort 排序標籤的 CSS Class.
  function getSortClass(key, sortConfig) {
    if (sortConfig.key !== key) {
      return "";
    }
    return (sortConfig.direction === "asc") ? "asc" : "desc";
  }

  // true 代表這個欄位 【不排序】.
  // false 這個欄位 【排序】.
  function isNonSortableFun(key) {
    if (key === "url") {
      return true;
    }
    return false;
  }

  // 點擊 URL 彈出子視窗.
  function openPopup(url) {
    window.open(url, "popup", "width=800,height=600,scrollbars=yes");
  }

  return (
    <div className="page-container">
      {/* Header */}
      <header className="header">
        <h2>React Data Grid Table</h2>
      </header>

      {/* Main */}
      <main className="main-content">
        {/* 搜尋與分頁選擇 */}
        <div className="top-controls">
          <input
            type="text"
            placeholder="搜尋 Title..."
            value={searchText}
            onChange={(e) => {
              setSearchText(e.target.value);
              setCurrentPage(1);
            }}
          />
          <br />

          {/* 資料表 */}
          <table className="data-table">
            <thead>
              <tr>
                {tableHeader.map((header) => {
                  /* 『true』 表示此欄位不排序. */
                  const isNonSortable = isNonSortableFun(header.key);

                  const tSortClass = getSortClass(header.key, sortConfig);

                  /* check 檢查 當前的 欄位 是 排序欄位. */
                  const isActive = (sortConfig.key === header.key);

                  /* 切換顯示上下符號icon排序 */
                  const tempArrow = isActive && (sortConfig?.direction === "asc" ? "↑" : "↓");

                  return (
                    /* <th key={header.key} scope="col"> */
                    <th key={header.key}>
                      {isNonSortable ? (
                        /* 不可排序. */
                        <span>{header.label}</span>
                      ) : (
                        /* 其它欄位顯示為可操作按鈕，並會顯示排序 icon. */
                        <div onClick={() => requestSort(header.key)}>
                          <span>{header.label}</span>
                          <span className={`sort-icon ${tSortClass}`}>
                            <span>| {tempArrow}</span>
                          </span>
                        </div>
                      )}
                    </th>
                  );
                })}
              </tr>
            </thead>
            <tbody>
              {(pagedData.length > 0) ? (
                pagedData.map((row) => {
                  return (
                    <tr key={`${row.No}_computer`}>
                      <td>{row.No}</td>
                      <td>{row.title}</td>
                      <td>{row.content}</td>
                      <td className="price">
                        {getPrice(row.price.toLocaleString())}
                      </td>
                      <td>
                        <a
                          onClick={() => openPopup(row.url)}
                          style={{ color: "blue", textDecoration: "underline" }}
                        >
                          詳情頁
                        </a>
                      </td>
                    </tr>
                  );
                })
              ) : (
                <tr>
                  <td colSpan={4} className="no-data">
                    找不到符合的資料
                  </td>
                </tr>
              )}
            </tbody>
          </table>

          <br />
          <br />

        </div>

        {/* 分頁控制 */}
        <div>
          <div className="pagination">
            <div className="select-container">
              <label>每頁筆數：</label>
              <select
                value={rowsPerPage}
                onChange={(e) => {
                  setRowsPerPage(Number(e.target.value));
                  setCurrentPage(1);
                }}
              >
                <option value={5}>5筆</option>
                <option value={10}>10筆</option>
              </select>
            </div>

            <p>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </p>

            <button
              onClick={() => handlePageChange(currentPage - 1)}
              disabled={currentPage === 1}
            >
              上一頁
            </button>
            <span>
              頁面 {currentPage} / {totalPages}
            </span>
            <button
              onClick={() => handlePageChange(currentPage + 1)}
              disabled={currentPage === totalPages}
            >
              下一頁
            </button>
          </div>

        </div>
      </main >

      {/* Footer */}
      < footer className="footer" >React DataGrid 小練習</footer >
    </div >
  );
}

export default DataGridPage;
