package com.joshuainchilliwack.java.algorithm;

public class Queue<T> {

	private Node first;
	private Node last;
	private int length;

	public Queue() {
		first = null;
		last = null;
		length = 0;
	}

	public T peak() {

		if (length == 0) {
			return null;
		}
		return first.getValue();
	}

	public void enqueue(T value) {
		Node newNode = new Node(value);
		if (length == 0) {
			first = newNode;
			last = newNode;
		} else {
			last.setNext(newNode);
			last = newNode;
		}

		length++;
	}

	public T dequeue() {

		if (first == null) {
			return null;
		}

		if (first == last) {
			last = null;
		}
		
		Node temp = first;
		first = first.getNext();
		length--;

		return temp.getValue();

	}

	public void printQueue() {
		if (first == null) {
			return;
		}
		Node currentNode = first;
		System.out.print(currentNode.getValue());
		currentNode = currentNode.getNext();
		while (currentNode != null) {
			System.out.print("-->" + currentNode.getValue());
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

	class Node {

		private T value;
		private Node next;

		Node(T value) {
			this.value = value;
			this.next = null;
		}

		Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
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

		Queue<Integer> queue = new Queue<>();
		queue.enqueue(5);
		queue.printQueue();
		queue.enqueue(3);
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(8);
		queue.printQueue();

		Queue<String> queue2 = new Queue<>();
		queue2.enqueue("banana");
		queue2.printQueue();
		queue2.enqueue("apple");
		queue2.printQueue();
		queue2.dequeue();
		queue2.dequeue();
		queue2.enqueue("orange");
		queue2.printQueue();
	}

}