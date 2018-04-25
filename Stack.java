package demos;

import java.util.NoSuchElementException;

public class Stack {
	
	private Node first; 
	
	/**
	 * adds an element to the stack
	 * @param data- the element to add
	 */
	public void push(Object data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		first = newNode;
	}
	/**
	 * removes the last element added to the stack 
	 * @return the element removed, type Object
	 */
	public Object pop() {
		if(first == null) { 
			throw new NoSuchElementException(); 
		}
		Object temp = first.data;
		first = first.next;
		return temp;
	}
	
	/**
	 *  peeks 
	 * @returns the last element added to the stack
	 */
	public Object peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	
	
	class Node{
		public Object data;
		public Node next;
	}

}
