package demos;

public interface ListIterator {
	/**
	 * iterates past the next object in the list
	 * @return the object that was traversed by the iterator
	 */
	public Object next();
	
	/**
	 * checks if there is a next object
	 * @return true if the next object is not null, false otherwise
	 */
	
	public boolean hasNext();
	
	
	/**
	 * adds the given data to the current iterator position
	 * advances the iterator past the new object
	 * @param data -  the new data
	 */
	public void add(Object data);
	
	/**
	 * removes the object at the current iterator position
	 * @return the object stored in the element that was deleted
	 */
	public Object remove();
	
	/**
	 * overwrites data in the current position with the given data
	 * @param data the data to store
	 */
	public void set(Object data);
	

}
