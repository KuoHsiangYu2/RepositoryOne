import static java.lang.System.out;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMapDataTransform {

	public static void main(String[] args) {
		Set<Doc> docsList = new HashSet<Doc>();
		// 第一層資料夾 2
		// 第二層資料夾 2.1
		// 第三層資料夾 2.1.1
		docsList.add(new Doc(1, "2 母目錄"));
		docsList.add(new Doc(2, "2.1 子目錄"));
		docsList.add(new Doc(3, "2.1.1 孫目錄"));
		docsList.add(new Doc(4, "2.2 子目錄2"));

		int docsListLength = docsList.size();
		String[] docsListKey = new String[docsListLength];
		String[] docListValue = new String[docsListLength];
		int[] keyLength = new int[docsListLength];
		int[] docObjKey = new int[docsListLength];
		int maxKeyLength = Integer.MIN_VALUE;// 找出keyLength最長的長度
		int index = 0;
		Map<String, String> docsLocationMap = new HashMap<String, String>();
		Iterator<Doc> docsListIterator = docsList.iterator();
		while (docsListIterator.hasNext()) {
			Doc doc = docsListIterator.next();
			String docLocStr = doc.getWBSLocation();
			String[] docLocStrArr = docLocStr.split(" ");
			docsListKey[index] = docLocStrArr[0];
			docListValue[index] = docLocStrArr[1];
			keyLength[index] = docLocStrArr[0].length();
			docObjKey[index] = doc.getDocObjKey();
			if (keyLength[index] > maxKeyLength) {
				maxKeyLength = keyLength[index];
			}
			docsLocationMap.put(docLocStrArr[0], docLocStrArr[1]);
			index++;
		}
		docsListIterator = null;

		// 從最長的key值依序往下走訪
		for (int i = maxKeyLength; i >= 1; i--) {
			for (int j = 0, len = docsListKey.length; j < len; j++) {
				if (keyLength[j] == i) {
					// 從最長的key值長度開始搜尋
					// 也就是孫級資料夾、接著子級資料夾、接著父級資料夾、最後是初始根目錄資料夾
					for (int k = (docsListKey[j].length() - 1); k >= 1; k--) {
						// 進行字串切割，把後端的字元一個一個切掉
						String comparStr = docsListKey[j].substring(0, k);

						// 如果符合，代表這個是子資料夾上層的父資料夾，
						// 把父資料夾的名稱加在子資料夾名稱前面。
						if (docsLocationMap.containsKey(comparStr)) {
							// 把父節點位置的資料夾名稱加在前面。
							docListValue[j] = docsLocationMap.get(comparStr) + File.separator + docListValue[j];
						}
					}
				}
			}
		}

		out.println(Arrays.toString(docListValue));

		docsListIterator = docsList.iterator();
		while (docsListIterator.hasNext()) {
			Doc doc = docsListIterator.next();
			int docObj = doc.getDocObjKey();
			for (int i = 0, len = docObjKey.length; i < len; i++) {
				// 最後一個步驟，根據 docObj索引值 把運算完成的WBSLocation設回去相對應的doc物件。
				if (docObj == docObjKey[i]) {
					doc.setWBSLocation(docListValue[i]);
				}
			}
		}
		docsListIterator = null;

		for (Doc docUnit : docsList) {
			out.println(docUnit.getWBSLocation());
		}
		out.println();
	}

}
