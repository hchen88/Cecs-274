package project;

import java.util.NoSuchElementException;

public class LinkedList {
	
	private Node first; 
	
	public LinkedList() {
		first = null;
	}
	
	/**
	 * adds an element to the head of the list
	 * @param data - the object to store at the head of the list
	 */
	public void addFirst(Object data) {
		Node newNode = new Node();
		newNode.data = data; //no setter necessary
		if(first != null) {
			newNode.next = first;
		}
			first = newNode;
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
		return temp; 
	}
	
	public ListIterator listIterator () { //NOTE: we return a list iterator because it is a PUBLIC interface
		//that can only be used outside of the LinkedList class 
		return new LinkedListIterator();
	}
	 
	class LinkedListIterator implements ListIterator {
		private Node position;
		private Node previous;
		private boolean isAfterNext;
		
		public LinkedListIterator () {
			position = null; //initializing the iterator to stand before the list begins
			previous = null;
			isAfterNext = false;
		}
		

		@Override
		public Object next() {
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
			if (position == null) { //if the iterator is at the beginning of the list
				return first != null;
			}
			else {
				return position.next != null;
			}
		}

		@Override
		public void add(Object data) {
			
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
			if(position == null) {
				throw new NoSuchElementException();
			}
			position.data = data;
			
		}


		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	
	//node is an inner class so access is restricted to members of its outer class only
	class Node {
		//these variables don't need setters or getters and can be accessed or modified by any member of the outer class
		//
		public Object data;
		public Node next;
		
	}

}
