import static java.lang.System.out;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		/* 11 12 22 78 89 23 78 */
		/* 55 56 78 89 88 45 34 */
		/* 22 77 88 99 66 44 33 */

		// [11]，載入類別，只執行static區塊程式碼
		Class.forName("stupid_teacher");

		// [12]，載入類別，只執行static區塊程式碼
		Class.forName("stupid_senior");

		// [22]
		new StupidTeacher(65, 'A');

		// [78]
		StupidTeacher st = new StupidSenior();
		((StupidSenior) st).stupid_senior2(10, 20);

		// [89]
		((StupidSenior) st).stupid_senior2(10, 20, 30);

		// [23]
		new StupidSenior(10);

		// [78]
		((StupidSenior) st).stupid_senior2(10, 20);

		out.printf("%n");

		// [55]
		new StupidTeacher(10, "abc");

		// [56]
		new StupidSenior(10, "abc");

		// [78]
		((StupidSenior) st).stupid_senior2(10, 20);

		// [89]
		((StupidSenior) st).stupid_senior2(10, 20, 30);

		// [88]
		st.stupid_teacher2(10, 20, 30, 40, 50);

		// [45]
		new StupidSenior(10, 20, 30, 40, 50);

		// [34]
		new StupidSenior(10, 20);

		out.printf("%n");

		// [22]
		new StupidTeacher(65, 'A');

		// [77]
		st.stupid_teacher2(10, 20);

		// [88]
		st.stupid_teacher2(10, 20, 30, 40, 50);

		// [99]
		st.stupid_teacher2(10, "abc");

		// [66]
		st.stupid_teacher2(10);

		// [44]
		new StupidTeacher(10, 20, 30, 40, 50);

		// [33]
		new StupidTeacher(10, 20);

		out.printf("%n");
	}

}

class StupidTeacher {
	static {
		out.print(11);
	}

	StupidTeacher() {
	}

	StupidTeacher(int a, char b) {
		out.print(22);
	}

	StupidTeacher(int a, int b) {
		out.print(33);
	}

	StupidTeacher(int... a) {
		out.print(44);
	}

	StupidTeacher(int a, String b) {
		out.print(55);
	}

	void stupid_teacher2(int a) {
		out.print(66);
	}

	void stupid_teacher2(int a, int b) {
		out.print(77);
	}

	void stupid_teacher2(int... a) {
		out.print(88);
	}

	void stupid_teacher2(int a, String b) {
		out.print(99);
	}
}

class StupidSenior extends StupidTeacher {
	static {
		out.print(12);
	}

	StupidSenior() {
	}

	StupidSenior(int a) {
		out.print(23);
	}

	StupidSenior(int a, int b) {
		out.print(34);
	}

	StupidSenior(int... a) {
		out.print(45);
	}

	StupidSenior(int a, String b) {
		out.print(56);
	}

	void stupid_senior2(int a, int b) {
		out.print(78);
	}

	void stupid_senior2(int... a) {
		out.print(89);
	}
}