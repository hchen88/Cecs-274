package demos;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList names = new LinkedList();
		names.addFirst("Carmen"); // C
		names.addFirst("Tom"); // T C
		names.addFirst("Juni"); // J T C
		names.addFirst("Oscar");// O J T C
		names.addFirst("Ana"); // A O J T C
		
		ListIterator iter = names.listIterator();
		iter.next(); // A | O J T C 
		iter.next();// A O | J T C
		System.out.println("Removed item: " + iter.remove());
		System.out.println("Rest of the list: " );
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("\nFull Contents: ");
		iter =  names.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		iter = names.listIterator();
		iter.next();
		System.out.println("\nRemoved the first element: " + iter.remove());
		// | J T C
		iter.next(); // J | T C
		iter.next(); // J T | C
		iter.add("Dustin Megatron"); // J | T D C
		
		System.out.println("\nList After Edit: ");
		iter =  names.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		iter =  names.listIterator();
		iter.next(); // J | T D C
		iter.add("Starscream");
		
		System.out.println("\nList After Edit: ");
		iter =  names.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		iter =  names.listIterator(); // | S J T D C
		iter.next(); // S | J T D C
		iter.next();// S J | T D C
		iter.set("Delly");
		
		System.out.println("\nList After Edit: ");
		iter =  names.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//		names.removeFirst(); // O J T C
//		iter = names.listIterator();
//		
//		System.out.println("\nAfter removing the first element: ");
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}
//		
//		
//		System.out.println(names.getFirst()); //A O J T C
//		System.out.println(names.removeFirst()); // O J T C 
//		System.out.println(names.removeFirst()); // J  T C
//		System.out.println(names.removeFirst()); // J T C
//		System.out.println(names.removeFirst()); // T C
//		System.out.println(names.removeFirst()); // C
//
//		
//		ListIterator iter = names.listIterator();
//		System.out.println(iter.hasNext());
	}

}
