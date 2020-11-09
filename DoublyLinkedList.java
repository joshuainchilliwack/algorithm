
public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	public DoublyLinkedList(int value) {
		head = new Node(value);
		tail = head;
		length = 1;
	}

	public void append(int value) {
		Node newNode = new Node(value, tail, null); // current tail should be previous node to the new node
		tail.setNext(newNode);
		tail = newNode; // make the new node the tail
		length++;
	}

	public void prepend(int value) {
		Node newNode = new Node(value, null, head); // current head should be next node to the new node
		head.setPrevious(newNode);
		head = newNode; // make the new node the head
		length++;
	}

	public void insert(int index, int value) {
		index = getSafeIndex(index);
		if (index == 0) {
			prepend(value);
			return;
		}

		if (index == length - 1) {
			append(value);
			return;
		}

		Node leader = traverseToIndex(index - 1);
		Node follower = leader.getNext();

		Node newNode = new Node(value, leader, follower);
		leader.setNext(newNode);
		follower.setPrevious(newNode);
		length++;
	}

	public void remove(int index) {
		index = getSafeIndex(index);
		if (index == 0) {
			head = head.getNext();
			return;
		}

		Node leader = traverseToIndex(index - 1);
		Node nodeToRemove = leader.getNext();
		leader.setNext(nodeToRemove.getNext());
		if (nodeToRemove.getNext() != null) {
			nodeToRemove.getNext().setPrevious(leader);
		}
		length--;
	}

	public void printList() {
		Node currentNode = head;
		System.out.print(currentNode.getValue());
		currentNode = currentNode.getNext();
		while (currentNode != null) {
			System.out.print("-->" + currentNode.getValue());
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public int getLength() {
		return length;
	}

	private Node traverseToIndex(int index) {
		index = getSafeIndex(index);
		Node currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	private int getSafeIndex(int index) {
		return Math.max(Math.min(index, length - 1), 0);
	}

	class Node {

		private int value;
		private Node previous;
		private Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}

		Node(int value, Node previous, Node next) {
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList linkedList = new DoublyLinkedList(5);
		linkedList.append(6);
		linkedList.append(4);
		linkedList.prepend(11);
		linkedList.printList();
		linkedList.insert(2, 12);
		linkedList.printList();
		linkedList.remove(4);
		linkedList.printList();
	}

}
