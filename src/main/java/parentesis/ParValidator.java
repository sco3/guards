package parentesis;

import static java.lang.System.out;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ParValidator {

	static Map<Character, Character> compliment = new HashMap<>();
	static {
		compliment.put('(', ')');
		compliment.put('{', '}');
		compliment.put('[', ']');
	}

	public static boolean validate(char[] line) {
		Deque<Character> deq = new ArrayDeque<Character>();
		for (char c : line) {
			switch (c) {
			case '(':
			case '{':
			case '[':
				deq.push(compliment.get(c));
				break;
			case ')':
			case '}':
			case ']':
				if (deq.size() == 0) {
					return false;
				}
				char before = deq.peekFirst();
				if (before == c) {
					deq.pop();
				} else {
					return false;
				}
				break;
			}

		}
		if (deq.size() == 0) {
			return true;
		}
		return false;

	}

	private static void test(String sample) {
		out.println("Check " + sample + " " + validate(sample.toCharArray()));
	}

	public static void main(String[] argv) {
		test("[{{}}]");

		test("");

		test("[");
		test("(");
		test("{");

		test("]");
		test(")");
		test("}");

		test("[]");
		test("()");
		test("{}");

		test("[{{}}]");
		test("([[]])");
		test("{()}");

	}

}
