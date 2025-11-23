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

	public static String reverseRec(String s) {
		if (s.length() <= 1) {
			return s;
		}
		return (reverseRec(s.substring(1)) + s.charAt(0));
	}

	public static void main(String[] argv) {
		String s = "12345";
		System.out.println("Original: " + s);
		System.out.println("Reversed: " + reverseRec(s));
		System.out.println("Reversed: " + reverse(s));
	}

}
