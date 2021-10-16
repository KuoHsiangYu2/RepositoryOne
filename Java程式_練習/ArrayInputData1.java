/* https://www.facebook.com/groups/1403852566495675/posts/3018458145035101/ */
import static java.lang.System.out;

import java.util.Scanner;

public class ArrayInputData1 {

    public static void main(String[] args) {
        float[] data = new float[5];
        Scanner scanner = new Scanner(System.in);

        out.println("Please input data.");
        for (int i = 0, len = data.length; i < len; i++) {
            out.printf("%02d. ", (i + 1));
            data[i] = scanner.nextFloat();
        }

        out.println("print data array.");
        for (int i = 0, len = data.length; i < len; i++) {
            out.printf("data[%d] = %f%n", i, data[i]);
        }

        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

}
