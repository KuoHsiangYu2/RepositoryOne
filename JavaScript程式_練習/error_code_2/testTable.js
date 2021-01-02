/*
狀態：已解決
預期結果：把 原始列 上下拖移後，會在 table同一行 目標列 上方或下方 出現 原始列。
實際情況：把 原始列 上下拖移後，會在 table 加開 第二行 第三行 並在目標列右邊出現原始列。
推測程式錯誤區塊：function dropHandler(e)。
解決方法：把 appendChild() 改寫成 insertAdjacentElement() 即可讓新的元素長在目標元素後面。
*/

/*
參考資料：
Element.insertAdjacentElement()
https://developer.mozilla.org/en-US/docs/Web/API/Element/insertAdjacentElement

PJCHENder
那些沒告訴你的小細節
—唯有自己整理過的東西，才是自己的—
[筆記] 製作可拖曳的元素（HTML5 Drag and Drop API）
https://pjchender.blogspot.com/2017/08/html5-drag-and-drop-api.html

關於表格內的拖拉問題
https://ithelp.ithome.com.tw/questions/10194089

SortableJS
JavaScript library for reorderable drag-and-drop lists
https://sortablejs.github.io/Sortable/

Sortable is a JavaScript library for reorderable drag-and-drop lists.
https://github.com/SortableJS/Sortable

HTML <input> maxlength Attribute
https://www.w3schools.com/tags/att_input_maxlength.asp

HTML <input> size Attribute
https://www.w3schools.com/tags/att_input_size.asp
*/

"use strict";

var showDataObj = document.getElementById("showData");
var addRowObj = document.getElementById("addRow");
var countRow = 0;// 計算有幾列
var editList = [];// 儲存分類清單的陣列

function cancelDefaultHandler(e) {
	e.preventDefault();
	e.stopPropagation();
	return false;
}

function renameTdNo() {
	var tdNoArray = document.getElementsByClassName("no");
	var length = tdNoArray.length;
	var n = 1;
	for (var i = 0; i < length; i++) {
		tdNoArray[i].innerText = String(n);
		tdNoArray[i].setAttribute("text", String(n));
		n = n + 1;
	}
}

function createTableRow(idData, textData) {
	var newTrObj = document.createElement("tr");
	newTrObj.setAttribute("draggable", "true");

	// 第1個 td
	var td1Obj = document.createElement("td");
	td1Obj.setAttribute("align", "center");
	td1Obj.setAttribute("class", "no");
	td1Obj.appendChild(document.createTextNode(idData));
	newTrObj.appendChild(td1Obj);

	// 第2個 td
	var td2Obj = document.createElement("td");
	td2Obj.setAttribute("width", "160px");
	var inputObj = document.createElement("input");
	inputObj.setAttribute("type", "text");
	inputObj.setAttribute("name", "typeList");
	inputObj.setAttribute("value", textData);
	inputObj.setAttribute("maxlength", 30);
	inputObj.setAttribute("size", 30);
	if (Number.parseInt(idData) === 1) {
		// 第一列禁止修改編輯
		inputObj.setAttribute("readonly", "readonly");
		// 第一列禁止拖移
		newTrObj.setAttribute("draggable", "false");
	} else if (Number.parseInt(idData) === 2) {
		// 第二列自動聚焦
		inputObj.setAttribute("autofocus", "autofocus");
	} else {
		// do nothing
	}
	td2Obj.appendChild(inputObj);
	newTrObj.appendChild(td2Obj);

	// 第3個 td
	var td3Obj = document.createElement("td");
	var buttonObj = document.createElement("button");
	buttonObj.setAttribute("type", "button");
	buttonObj.setAttribute("onclick", "deleteRow(this)");
	buttonObj.innerText = "刪除";
	td3Obj.appendChild(buttonObj);
	newTrObj.appendChild(td3Obj);

	newTrObj.addEventListener("dragstart", dragStartHandler);
	newTrObj.addEventListener("dragenter", cancelDefaultHandler);
	newTrObj.addEventListener("dragover", cancelDefaultHandler);
	newTrObj.addEventListener("drop", dropHandler);

	return newTrObj;
}

function dropHandler(e) {
	// 放開滑鼠左鍵，把拖移物件放下狀態
	console.log("dropHandler");
	// 取消預設動作
	// e.preventDefault();
	// e.stopPropagation();

	// 取出拖放資料
	var dataObj = e.dataTransfer.getData("text");// 欄位資料
	dataObj = JSON.parse(dataObj);
	var textData = dataObj.text;// 欄位資料
	var idData = dataObj.id;// 欄位編號

	console.log("textData");
	console.log(textData);
	console.log("idData");
	console.log(idData);

	// console.log("typeof (idData)");
	// console.log(typeof (idData));

	// console.log("e.currentTarget");
	// console.log(e.currentTarget);

	// console.log("舊 idData");
	// console.log(idData);

	// console.log("新 e.currentTarget.childNodes[0].childNodes[0].nodeValue");
	// console.log(e.currentTarget.childNodes[0].childNodes[0].nodeValue);

	var oldNo = Number.parseInt(idData);
	var newNo = Number.parseInt(e.currentTarget.childNodes[0].childNodes[0].nodeValue);
	console.log("舊 oldNo = " + oldNo);
	console.log("新 newNo = " + newNo);

	console.log("source");
	console.log(document.querySelector(".no[text='" + String(oldNo) + "']"));
	console.log("source.parentElement");
	console.log(document.querySelector(".no[text='" + String(oldNo) + "']").parentElement);
	var oldTrObj = document.querySelector(".no[text='" + String(oldNo) + "']").parentElement;
	console.log("oldTrObj");
	console.log(oldTrObj);

	if (oldNo !== newNo) {
		oldNo = oldNo - 1;
		showDataObj.deleteRow(oldNo);// 刪除舊列

		var newTrObj = createTableRow(idData, textData);

		e.currentTarget.insertAdjacentElement("afterend", newTrObj);// 新增新列
	}

	renameTdNo();// 重新排序 no值
}

function dragStartHandler(e) {
	// 當目標物被滑鼠左鍵點住拖移時
	// 儲存要拖放的資料
	console.log("dragStartHandler");

	console.log("e");
	console.log(e);

	console.log("e.dataTransfer");
	console.log(e.dataTransfer);

	var text = e.target.childNodes[1].childNodes[0].value;// 文字內容
	var id = e.target.childNodes[0].childNodes[0].nodeValue// id編號

	var dataObj = {
		"text": text,
		"id": id
	};

	e.dataTransfer.setData("text", JSON.stringify(dataObj));
}

function initialTable() {
	// 初始化整個分類清單
	var length = editList.length;
	for (countRow = 0; countRow < length; countRow++) {
		var newTrObj = createTableRow(String(countRow + 1), editList[countRow]);

		showDataObj.appendChild(newTrObj);
		// 從for迴圈出來後 countRow === length ，所以外面不需要再做 countRow++; 的動作。
	}
	renameTdNo();
}

var result = ["未分類", "Sword Art Online", "Kirito", "Asuna", "Starburst Stream", "Gun Gale Online",
	"Alicization War of Underworld", "Alice Synthesis Thirty", "Enhance Armament", "Release Recollection"];

for (var i = 0, len = result.length; i < len; i++) {
	editList.push(result[i]);
}

for (var i = 1; i <= 3; i++) {
	// 再加入3個預設的空白。
	editList.push("");
}

// 開始執行繪製表格的動作
initialTable();

// 刪除一列
function deleteRow(buttonObj) {
	var isDelete = confirm("確定要刪除嗎？");
	if (true === isDelete) {
		if (countRow === 1) {
			// 只剩一列就不要再刪了。
			window.alert("分類名單不可為空！");
			return;
		}
		var trObj = buttonObj.parentElement.parentElement;
		var td1NoObj = trObj.childNodes[0];
		if (td1NoObj.childNodes[0].nodeValue === "1") {
			// 檢查是否為第一列的程式
			// 第一列 [未分類] 禁止使用者刪除
			window.alert("[未分類] 為不可刪除項目！");
			return;
		}

		var tbodyObj = buttonObj.parentElement.parentElement.parentElement;
		tbodyObj.removeChild(trObj);

		renameTdNo();
		countRow = countRow - 1;
	} else {
		// do nothing
	}
}

// 新增一列
addRowObj.addEventListener("click", function () {
	var lastTrObj = document.querySelector("#showData tr:last-child");

	var newTrObj = createTableRow(String(countRow), "");

	lastTrObj.insertAdjacentElement("afterend", newTrObj);

	renameTdNo();
	countRow = countRow + 1;
});