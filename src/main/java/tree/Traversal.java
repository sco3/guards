package tree;

// 13:18
public class Traversal {
	public static class TreeNode {
		int item;
		TreeNode left;
		TreeNode right;

		public TreeNode(int anItem) {
			item = anItem;
		}
	}

	public static void traverse(TreeNode root) {
		if (root == null) {
			return;
		}
		traverse(root.left);
		traverse(root.right);
		System.out.println("" + root.item);

	}

	public static void main(String[] argv) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		traverse(root);
	}

}
