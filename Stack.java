package com.joshuainchilliwack.java.algorithm;

import java.util.EmptyStackException;

public class Stack<T> {

	private Node top;
	private Node bottom;
	private int length;

	public Stack() {
		top = null;
		bottom = null;
		length = 0;
	}

	public T peak() {

		if (length == 0) {
			throw new EmptyStackException();
		}
		return top.getValue();
	}

	public void push(T value) {
		top = new Node(value, top);
		if (length == 0) {

			bottom = top;
		}

		length++;
	}

	public T pop() {

		if (length == 0) {
			throw new EmptyStackException();
		}

		Node temp = top;
		top = top.getNext();
		length--;
		if (length == 0) {
			bottom = null;
		}
		return temp.getValue();

	}

	public void printStack() {
		if (top == null) {
			return;
		}
		Node currentNode = top;
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

		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.printStack();
		stack.push(3);
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.push(8);
		stack.printStack();
		
		Stack<String> stack2 = new Stack<>();
		stack2.push("banana");
		stack2.printStack();
		stack2.push("apple");
		stack2.printStack();
		stack2.pop();
		stack2.pop();
		stack2.push("orange");
		stack2.printStack();
	}

}
