// TODO: 如果瀏覽器沒有 String.prototype.padStart屬性，就自己設一個，自己的屬性自己設。一切都是為了 100% 支援 IE瀏覽器。
// https://www.itread01.com/content/1532584990.html
// https://developer.mozilla.org/zh-TW/docs/Web/JavaScript/Reference/Global_Objects/Array/unshift
// https://www.w3school.com.cn/jsref/jsref_unshift.asp
// https://ithelp.ithome.com.tw/articles/10205221
// https://developer.mozilla.org/zh-TW/docs/Web/JavaScript/Reference/Global_Objects/Array/join

if (!String.prototype.padStart) {
	
	// 為了支援IE瀏覽器而寫的函數。
	console.log('開始為 IE瀏覽器 加載 padStart()');
	String.prototype.padStart = function padStart(targetLength, padString) {
		
		/* truncate if number or convert non-number to 0; */
		targetLength = targetLength >> 0;

		// console.log('targetLength -> ' + targetLength);
		// console.log('this.length -> ' + this.length);
		padString = String((typeof padString !== 'undefined' ? padString : ' '));
		if (this.length >= targetLength) {
			// console.log('第一個if條件判斷式。');
			return String(this);
		} else {
			// console.log('第二個if條件判斷式。');
			let thisObj = String(this);
			let thisArray = thisObj.split('');
			// console.log('thisArray obj');
			// console.log(thisArray);
			
			while (thisArray.length < targetLength) {
				/* 從左邊開始插入padString */
				thisArray.unshift(padString);
			}

			/* 最後用 ''字串 隔開組合成一個完整的 String 回傳回去。 */
			return thisArray.join('');
		}
	};
}

