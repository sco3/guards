package listreverse;

import static java.lang.System.out;

// 20:57->22:00

public class ReinventWheelReverse {

	public static class LinkList {
		Integer item;
		LinkList next;

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			LinkList cur = this;

			while (cur.next != null) {
				sb.append(cur.item).append("->");
				cur = cur.next;
			}
			sb.append(cur.item);

			return sb.toString();
		}
	}

	public static LinkList reverse(LinkList ls) {
		return ls;
	}

	public static void main(String[] argv) {
		LinkList head = new LinkList();
		head.item = 1;
		head.next = new LinkList();
		head.next.item = 2;
		head.next.next = new LinkList();
		head.next.next.item = 3;
		head.next.next.next = new LinkList();
		head.next.next.next.item = 4;

		LinkList prev = null;
		var cur = head;
		LinkList next = null;

		while (cur != null) {
			out.println(prev + " | " + cur + " | " + next);
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		out.println(prev);

	}

}
