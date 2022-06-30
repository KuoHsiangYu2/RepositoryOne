import static java.lang.System.out;

public class MiraculousMultiplicationTable2 {

    public static void main(String[] args) {
        int[] column = new int[] { 7, 2 };
        int[] row = new int[] { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
        String resultStr = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                resultStr = String.format("%d * %d = %d\t", column[j], row[i], (column[j] * row[i]));
                out.print(resultStr);
            }
            out.println();
        }
    }

}
