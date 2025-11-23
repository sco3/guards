package reverse;

public class Reverser {
	public static String reverse(String s) {
		char[] str = s.toCharArray();
		var start = 0;
		var end = str.length - 1;

		while (start < end) {
			var cStart = str[start];
			str[start] = str[end];
			str[end] = cStart;
			start++;
			end--;
		}

		return new String(str);
	}

	public static void main(String[] argv) {
		System.out.println("Reversed: " + reverse("12345ДОД"));
	}

}
