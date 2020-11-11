package com.joshuainchilliwack.java.algorithm;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ListStack<T> {

	List<T> list = new ArrayList<T>();

	public T peak() {

		if (list.size() == 0) {
			throw new EmptyStackException();
		}
		return list.get(list.size() - 1);
	}

	public void push(T value) {
		list.add(value);
	}

	public T pop() {
		return list.remove(list.size() - 1);
	}

	public void printStack() {

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i < list.size() - 1)
				System.out.print("-->");
		}

		System.out.println();

	}

	public static void main(String[] args) {

		ListStack<Integer> stack = new ListStack<>();
		stack.push(5);
		stack.printStack();
		stack.push(3);
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.push(8);
		stack.printStack();

		ListStack<String> stack2 = new ListStack<>();
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
