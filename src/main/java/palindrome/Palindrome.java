package palindrome;

// 9:48-9:57
public class Palindrome {

	public static boolean check(String str) {

		char[] c = str.toCharArray();
		int left = 0;
		int right = c.length - 1;
		while (left < right) {
			while (!Character.isAlphabetic(c[left])) {
				left++;
			}
			while (!Character.isAlphabetic(c[right])) {
				right--;
			}
			char cLeft = Character.toLowerCase(c[left]);
			char cRight = Character.toLowerCase(c[right]);
			if (cLeft != cRight) {
				return false;
			}
			left++;
			right--;
		}

		return true;

	}

	public static void test(String s, boolean b) {
		boolean result = check(s);
		System.out.println(s + ": " + result + " " + b);
		assert result == b;
	}

	public static void main(String[] argv) {
		test("asdffdsa", true);
		test("asdf f d s a", true);
		test("asdf f d s.a", true);

		test("asdf f d c.a", false);

	}

}
