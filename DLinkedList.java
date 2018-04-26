package project;

import java.util.NoSuchElementException;

public class DLinkedList {
	
	private Node first; 
	private Node last;
	private int removeCounter = 0;
	
	public DLinkedList() {
		first = null;
		last = null;
	}
	
	/**
	 * adds the a new node to the tail of the list
	 * @param the object to store at the tail of the list
	 */
	public void addLast(Object data) {
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
	 * adds an element to the head of the list
	 * @param data - the object to store at the head of the list
	 */
	public void addFirst(Object data) {
		Node newNode = new Node();
		newNode.data = data;//no setter necessary
		if(first == null) {
			last = newNode;
		}else {
			first.previous = newNode;		
		}
			newNode.next = first;
			first = newNode;
	}
	/**
	 * gets the last element in list
	 * @return the last element in the list
	 */
	public Object getLast() {
		if(first == null) {
			throw new NoSuchElementException();
		}else {
			return last.data;
		}
		
	}
	/**
	 * gets what is stored at the beginning of this list
	 * @return - the data stored at the head of the list
	 */
	
	public Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		else {
			return first.data; //this is the syntax for getting the data attribute for the object called first
			//we are able to do this because the object itself is public and we don't need a getter method
		}
	}
	
	/** removes the head of the list;
	 * @return - returns the data of the node that was deleted
	 */
	public Object removeFirst() {
		if (first == null) { //if the list is empty
			throw new NoSuchElementException();
		}
		Object temp = first.data;
		first = first.next;
		removeCounter++;
		return temp; 
	}
	
	public Object removeLast() {
		if(first == null ) {
			throw new NoSuchElementException();
		}
		Object temp = last.data;
		last = last.previous;
		return temp; 
	}
	
	
	public ListIterator listIterator () { //NOTE: we return a list iterator because it is a PUBLIC interface
		//that can only be used outside of the LinkedList class 
		return new DLinkedListIterator();
	}
	 
	class DLinkedListIterator implements ListIterator {
		private Node position;
		private Node previous;
		private boolean isAfterNext, isAfterPrevious;
		
		
		public DLinkedListIterator () {
			position = null; //initializing the iterator to stand before the list begins
			previous = null;
			isAfterNext = false;
			isAfterPrevious = false;
		}

		@Override
		public Object next() {
			removeCounter = 0;
			if(!hasNext()) {throw new NoSuchElementException();}
			previous = position; // updating previous to be at the current position 
			if(position == null) {
				position = first;
			} else {
				position = position.next;
			}
			isAfterNext = true;
			return position.data;
		}

		public boolean hasNext() {
			removeCounter = 0;
			if (position == null) { //if the iterator is at the beginning of the list
				return first != null;
			}
			else {
				return position.next != null;
			}
		}

		@Override
		public void add(Object data) {
			removeCounter = 0;
			if(!isAfterNext) {throw new IllegalStateException();}
			if(position == first) {
				addFirst(data);
			} else {
				Node newNode = new Node();
				newNode.data = data;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}

		}

		@Override
		public Object remove() {
			removeCounter++;
			if (removeCounter > 1){
				throw new IllegalStateException();
			}
			if(!isAfterNext) {
				throw new IllegalStateException();
			}
			Object temp;
			if(position == first) {
				temp = removeFirst();
				
			}else {
				temp = position.data; // this holds the data of the 
				//node we are about to remove.
				previous.next = position.next;
			}
			position = previous;
			isAfterNext = false;
			return temp;
		}

		@Override
		public void set(Object data) {
			removeCounter = 0;
			if(position == null) {
				throw new NoSuchElementException();
			}
			position.data = data;
			
		}

		public Object previous() {
			removeCounter = 0;
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			} else {
			position = previous;
			}
			isAfterPrevious = true;
			return position.data;
		}

		public boolean hasPrevious() {
			removeCounter = 0;
			if(position == null) {
				return false;
			} else {
				return previous != null;
			}
		}
		
	}
	
	//node is an inner class so access is restricted to members of its outer class only
	class Node {
		//these variables don't need setters or getters and can be accessed or modified by any member of the outer class
		//
		public Object data;
		public Node next;
		public Node previous;
		
	}

}
