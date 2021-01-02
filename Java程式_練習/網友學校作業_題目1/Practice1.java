import static java.lang.System.out;

import java.util.Scanner;

public class Practice1 {

    public static void main(String[] args) {
        /* 利用 Scanner物件 跟 nextInt()方法 取得所輸入購買的巧克力數目N */
        int N = 0;
        Scanner scanner = new Scanner(System.in);

        out.printf("Input: ");
        N = scanner.nextInt();

        /* 設定一個變數total去紀錄最後實際拿到的巧克力數目 */
        int total = 0;

        /* 此total變數，一開始的數目是N */
        total = N;

        /* 接著，可利用while迴圈，去判斷當N >= 4時，便開始進行兌換的動作 */
        while (N >= 4) {
            /* 在while回圈內的兌換規則，可以宣告一變數cnt去紀錄該次所換得巧克力數 */
            int cnt = 0;

            /* 實際上，每次cnt的值將會是N除以4的商數 */
            cnt = N / 4;

            /* 每次算出cnt後，可將它累加至total */
            total = total + cnt;

            /* 另外，每次兌換後，也需要用另一變數remain去記錄兌換後所剩的巧克力數 */
            int remain = 0;

            /* 實際上，每次remain的值將會是N除以4的餘數 */
            remain = N % 4;

            /* 在進入下一輪的while迴圈前，可將N重新設定成cnt + remain(尚未兌換的包裝紙數目) */
            N = cnt + remain;
        }

        out.printf("Output = %d%n", total);

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
        out.println("finish");
    }// end of main() method
}

// Sample input: 7
// Sample output: 9

// Sample input: 12
// Sample output: 15

// 蘇莨凱
// 9 小時  · 
// 各位，這一題題目我想不通，還請各位為我解惑了
// https://www.facebook.com/groups/1403852566495675/permalink/2816435095237408/
