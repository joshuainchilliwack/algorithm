package com.joshuainchilliwack.java.algorithm;

import java.util.Stack;

public class StackQueue<T> {

	private Stack<T> stack;
	private Stack<T> tempStack;

	public StackQueue() {
		stack = new Stack<>();
		tempStack = new Stack<>();
	}

	// stack stores data as in the order of a queue
	public void enqueue(T value) {
		while (!stack.isEmpty()) {
			tempStack.push(stack.pop());
		}
		tempStack.push(value);
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public T dequeue() {

		return stack.pop();
	}

	public T peak() {

		return stack.peek();
	}

	public void printQueue() {
		if (stack.isEmpty()) {
			return;
		}

		Object[] list = stack.toArray();
		for (Object o : list) {
			System.out.print("-->" + o);
		}
		System.out.println();

	}

	public static void main(String[] args) {

		StackQueue<Integer> queue = new StackQueue<>();
		queue.enqueue(5);
		queue.printQueue();
		queue.enqueue(3);
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(8);
		queue.printQueue();

		StackQueue<String> queue2 = new StackQueue<>();
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