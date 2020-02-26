package midterm;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.print("請選擇運算式（+、-、*、/）：");
        int answer = 0;
        String operator = "";
        operator = scanner.next();
        int a = 0;
        int b = 0;
        out.print("Num 1：");
        a = scanner.nextInt();
        out.print("Num 2：");
        b = scanner.nextInt();
        switch (operator) {
        case "+":
            answer = a + b;
            out.println(answer);
            break;
        case "-":
            answer = a - b;
            out.println(answer);
            break;
        case "*":
            answer = a * b;
            out.println(answer);
            break;
        case "/":
            try {
                double answer2 = 0.0;
                answer2 = calculate(a, b);
                out.println(answer2);
            } catch (DivideException Ex) {
                err.println("Exception caught, msg = " + Ex.getMessage());
                err.println("Ex = " + Ex);
            }
            break;
        }
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }// end of main method

    public static double calculate(int a, int b) throws DivideException {
        double result = 0.0;
        if (b == 0) {
            DivideException Ex = new DivideException(b);
            throw Ex;
        } else {
            result = a / b;
            return result;
        }
    }// end of calculate method
}// end of Question1 class

class DivideException extends Exception {
    private static final long serialVersionUID = 1L;
    public int n = 0;

    public DivideException(int n) {
        super();
        this.n = n;
    }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        // return super.getMessage();
        return "Wrong number " + this.n;
    }

}// end of DivideException class
// 當你遇到 return, throw 都代表無條件 return

//https://www.facebook.com/groups/1403852566495675/permalink/2559629970917923/
//https://paste.ofcode.org/83hA5RSk5JrQrDjW6JkES8
