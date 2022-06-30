import static java.lang.System.out;

import java.util.Deque;
import java.util.LinkedList;

public class MiraculousMultiplicationTable3 {

    private static boolean isHead = false;

    private static void resetFlag() {
        isHead = false;
    }

    private static boolean getIsHeadFlag() {
        isHead = !isHead;
        return isHead;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 1; i <= 9; i++) {
            deque.addLast(i);
        }
        resetFlag();

        boolean isHeadFlag = true;
        int rowNumber = 0;
        String resultStr = "";
        for (int i = 0; i < 9; i++) {
            isHeadFlag = getIsHeadFlag();
            if (true == isHeadFlag) {
                // 從前面取值.
                rowNumber = deque.removeFirst();
            } else {
                // 從後面取值.
                rowNumber = deque.removeLast();
            }

            for (int j = 7; j >= 2; j = j - 5) {
                resultStr = String.format("%d * %d = %d\t", j, rowNumber, (j * rowNumber));
                out.print(resultStr);
            }
            out.println();
        }

    }

}
