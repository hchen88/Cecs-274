package project;

public class QueueDemo {
	
	public static void main(String[] args) {
		DLQueue q  = new DLQueue();
		q.add("Patrick"); //P 
		q.add("Sponge Bob"); // P S
		q.add("Dwight Schrute");// P S D
		q.add("Jim Halpert"); // P S D J
		q.add("Pam Beasley"); // P S D J P
		q.add("Tobey Flenderson"); // P S D J P T
		System.out.println(q.peek()); // T
		System.out.println(q.remove()); // T
		System.out.println(q.remove());// P
		System.out.println(q.remove());// J
		System.out.println(q.remove());// D
		
		
		
	}

}
