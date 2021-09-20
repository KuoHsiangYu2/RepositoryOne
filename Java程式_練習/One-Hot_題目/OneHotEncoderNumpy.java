
/* https://www.facebook.com/groups/pythontw/posts/10161581157078438/ */

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneHotEncoderNumpy {

    private static int[][] oneHotEncode(String inputStr) {
        inputStr = inputStr.trim();

        /* 字串用 [空格] 當切割符號 一塊塊 切片 */
        String[] inputCutArray = inputStr.split("[ ]{1,50}");

        /* 保存原始切片單字的 List */
        List<String> originalList = new ArrayList<String>(Arrays.asList(inputCutArray));

        /* 保有原始切片單字順序，且裡面單字都不重複的 List */
        List<String> uniqueList = new ArrayList<String>();

        String element = "";
        for (int i = 0, len = inputCutArray.length; i < len; i++) {
            element = inputCutArray[i].trim();
            if (false == uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        int rows = uniqueList.size();
        int columns = originalList.size();

        /* 建立用於儲存結果的二維陣列 */
        int[][] resultArray = new int[rows][columns];

        /* 進行 One-Hot運算，把 rows【列】 與 columns【行】 相同的部份標註為1 */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (true == uniqueList.get(i).equals(originalList.get(j))) {
                    resultArray[i][j] = 1;
                } else {
                    resultArray[i][j] = 0;
                }
            }
        }

        return resultArray;
    }

    public static void main(String[] args) {
        String inputStr = "to be or not to be";
        int[][] result = OneHotEncoderNumpy.oneHotEncode(inputStr);
        out.println("result = " + Arrays.deepToString(result));
    }
}
