//Name - Erick Torres, Zachariah Joseph
//Date - January the 11th, 2022
//Class - Beck - 4th Period
//Lab  - Basic Tree

package BasicTree;

public class BinarySearchTree<T extends Comparable> {
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null)
			tree = new TreeNode(val);

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);

		if (dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	// add preOrder, postOrder, and revOrder
	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void revOrder() {
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null) {
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight()))
			return 1 + getNumLevels(tree.getLeft());
		else
			return 1 + getNumLevels(tree.getRight());
	}

	// add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull
	public int getNumLeaves(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		return getNumLeaves(node.getLeft()) + getNumLeaves(node.getRight());
	}

	public int getWidth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.getLeft() == null && node.getRight() == null) {
			return 1;
		}
		return getWidth(node.getLeft()) + getWidth(node.getRight());
	}

	public int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int lHeight = getHeight(node.getLeft());
		int rHeight = getHeight(node.getRight());

		return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
	}

	public int getNumNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

0		return 1 + getNumNodes(root.getLeft()) + getNumNodes(root.getRight());
	}

	public boolean isFull(TreeNode node) {
		if (node == null) {
			return true;
		}

		if (node.getLeft() == null && node.getRight() == null) {
			return true;
		}

		if ((node.getLeft() != null) && (node.getRight() != null)) {
			return (isFull(node.getLeft()) && isFull(node.getRight()));
		}

		return false;
	}

	// add other options here

	public boolean search(Comparable item) {
		TreeNode currentNode = root;

		while (currentNode != null) {
			switch (item.compareTo(currentNode.getValue())) {
				case -1:
					currentNode = currentNode.getRight();
					break;
				case 1:
					currentNode = currentNode.getLeft();
					break;
				default:
					return true;
			}
		}

		return false;
	}

	// maxNode

	// minNode

	// level order

	// display like a tree
	public void displayTree(TreeNode root, int space) {
		// final int COUNT = 20;
		// // Base case
		// if (root == null) {
		// return;
		// }

		// space += COUNT;

		// displayTree(root.getRight(), space);

		// System.out.print("\n");
		// for (int i = COUNT; i < space; i++)
		// System.out.print(" ");
		// System.out.print(root.getValue() + "\n");

		// displayTree(root.getLeft(), space);
	}

	// remove
	public boolean remove(TreeNode tree) {
		if (tree == null)
			return false;

		if (tree.getLeft() == null && tree.getRight() == null) {
			tree = null;
			return true;
		} else if (tree.getLeft() == null) {
			tree = tree.getRight();
			return true;
		} else if (tree.getRight() == null) {
			tree = tree.getLeft();
			return true;
		} else {
			Comparable temp = tree.getValue();
			remove(tree.getLeft());
			tree.setValue(temp);
		}
		return false;
	}

	public String toString() {
		throw new UnsupportedOperationException();
	}

	private String toString(TreeNode tree) {
		throw new UnsupportedOperationException();
	}
}