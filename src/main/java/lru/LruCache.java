package lru;

import java.util.Map;

//13:06->13:22 (12 minutes)
// lunch 
//13:40->14:04 (24 minutes)
public class LruCache {
	interface ValueGetter {
		int getValue(int key);
	}

	class Node {
		int key, value;
		Node prev, next;

		public Node(int aKey, int aValue) {
			key = aKey;
			value = aValue;
		}
	}

	class DblLinkedList {
		Node head, tail;

		public void moveToHead(Node node) {
			if (node.prev != null) {
				node.prev.next = node.next;
			} else {
				head = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				tail = node.prev;
			}

			addToHead(node);
		}

		public Node removeTail() {

			if (tail == null) {
				return null;
			}
			Node remTail = tail;
			tail = tail.prev;

			if (tail != null) {
				tail.next = null;
			} else {
				head = null;
			}
			return remTail;
		}

		public void addToHead(Node node) {
			node.prev = null;
			node.next = head;
			if (head != null) {
				head.prev = node;
			}
			head = node;
			if (tail == null) {
				tail = node;
			}
		}
	}

	Map<Integer, Node> map;
	DblLinkedList dlList;
	ValueGetter getter;
	int capacity = 1000;

	public Integer get(int key) {
		Node node = map.get(key);
		if (node == null) {
			var value = getter.getValue(key);
			node = new Node(key, value);
			dlList.addToHead(node);
			map.put(key, node);
		} else {
			dlList.moveToHead(node);
		}

		return node.value;
	}

	public void put(int key, int value) {
		Node node = map.get(key);
		if (node == null) {
			node = new Node(key, value);
			map.put(key, node);
			dlList.addToHead(node);
			if (map.size() > capacity) {
				var removed = this.dlList.removeTail();
				map.remove(removed.key);
			}
		} else {
			node.value = value;
			dlList.moveToHead(node);
		}
	}
}
