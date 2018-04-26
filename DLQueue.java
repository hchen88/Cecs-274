package project;

import java.util.NoSuchElementException;

public class DLQueue {
	

	private Node first, last; 
	
	/**
	 * adds an element in end
	 * @param data- the element to add
	 */
	public void add(Object data) {
		Node newNode = new Node();
		newNode.data = data;
		if(first == null) {
			first = newNode;
		}else {
			last.next = newNode;
			newNode.previous = last;
		}
	
		last = newNode;
	}
	/**
	 * removes the first element added to the queue
	 * @return the element removed, type Object
	 */
	public Object remove() {
		if(first == null ) {
			throw new NoSuchElementException();
		}
		Object temp = last.data;
		last = last.previous;
		return temp; 
	}
	
	/**
	 *  peeks 
	 * @returns the last element added to the queue
	 */
	public Object peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return last.data;
	}

	
	class Node{
		public Object data;
		public Node next, previous;
	}

}
