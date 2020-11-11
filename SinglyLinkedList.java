package com.joshuainchilliwack.java.algorithm;

public class SinglyLinkedList {

	private Node head;
	private Node tail;
	private int length;

	public SinglyLinkedList(int value) {
		head = new Node(value);
		tail = head;
		length = 1;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		tail.setNext(newNode);
		tail = newNode; // make the new node the tail
		length++;
	}

	public void prepend(int value) {
		head = new Node(value, head); // make the new node the head
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

		Node newNode = new Node(value, leader.getNext());
		leader.setNext(newNode);
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

		length--;
	}

	public void reverse() {
		if (head.getNext() == null) {
			return;
		}

		Node first = head;
		tail = head;

		Node second = first.getNext();
		while (second != null) {
			Node temp = second.getNext();
			second.setNext(first);
			first = second;
			second = temp;

		}
		head.setNext(null);
		head = first;
	}

	public void printList() {

		if (head == null) {
			return;
		}

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
		private Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
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
	}

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList(5);
		linkedList.append(6);
		linkedList.append(4);
		linkedList.prepend(11);
		linkedList.printList();
		linkedList.insert(2, 12);
		linkedList.printList();
		linkedList.remove(4);
		linkedList.printList();
		linkedList.reverse();
		linkedList.printList();
	}

}
