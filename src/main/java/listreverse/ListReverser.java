package listreverse;

import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.LinkedList;

//16:35  -> 17:00

public class ListReverser {
	public static LinkedList<Integer> reverse(LinkedList<Integer> ls) {
		LinkedList<Integer> rev = new LinkedList<>();
		while (!ls.isEmpty()) {
			int e = ls.removeFirst();
			rev.addFirst(e);
		}
		return rev;

	}

	public static void main(String[] argv) {
		LinkedList<Integer> ls = new LinkedList<>();
		ls.addAll(asList(1, 2, 3, 4));

		var rev = reverse(ls);

		out.println("Out: " + rev);

	}

}
