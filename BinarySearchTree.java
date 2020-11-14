
package com.joshuainchilliwack.java.algorithm;

public class BinarySearchTree {

	private Node root;

	public void insert(int value) {

		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
		} else {
			Node currentNode = root;
			while (true) {
				if (value < currentNode.getValue()) {
					if (currentNode.getLeft() == null) {
						currentNode.setLeft(newNode);
						break;
					} else {
						currentNode = currentNode.getLeft();
					}
				} else {
					if (currentNode.getRight() == null) {
						currentNode.setRight(newNode);
						break;
					} else {
						currentNode = currentNode.getRight();
					}
				}
			}
		}
	}

	public Node search(int value) {
		if (root == null) {
			return null;
		}

		Node currentNode = root;

		while (currentNode != null) {
			if (value < currentNode.getValue()) {
				currentNode = currentNode.getLeft();
			} else if (value > currentNode.getValue()) {
				currentNode = currentNode.getRight();
			} else {
				return currentNode;
			}
		}

		return null;
	}

	static int cnt;

	public void printTree(Node node) {
		System.out.print(node.getValue());
		System.out.println();

		cnt++;
		
		if (node.getLeft() != null) {
			System.out.print("\t".repeat(cnt) + "Left: ");
			printTree(node.getLeft());
		}
		if (node.getRight() != null) {
			System.out.print("\t".repeat(cnt) + "Right: ");
			printTree(node.getRight());
		}
		
		cnt--;
	}

	public Node getRoot() {
		return root;
	}

	class Node {
		private int value;
		private Node left;
		private Node right;

		Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(9);
		tree.insert(4);
		tree.insert(20);
		tree.insert(1);
		tree.insert(6);
		tree.insert(15);
		tree.insert(170);
		cnt = 0;
		tree.printTree(tree.getRoot());
		// tree.remove(20);
		// tree.remove(4);
		
		tree.printTree(tree.getRoot());
		tree.insert(20);
		tree.insert(18);
		tree.insert(10);
		
		tree.printTree(tree.getRoot());
		// tree.remove(170);
		
		tree.printTree(tree.getRoot());
	}

}
