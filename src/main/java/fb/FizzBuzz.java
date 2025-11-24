package fb;

import static java.lang.System.out;

public class FizzBuzz {

	public static void check(int n, int a, int b) {
		var common = a * b;
		for (int i = 1; i <= n; i++) {
			if (i % common == 0) {
				out.println(i + ": fizzbuzz");
			} else if (i % a == 0) {
				out.println(i + ": fizz");

			} else if (i % b == 0) {
				out.println(i + ": buzz");

			} else {
				out.println("" + i);
			}
		}
	}

	public static void main(String[] argv) {
		check(15, 3, 5);
	}

}
