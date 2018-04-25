package demos;

public class StackDemo {
	
	public static void main(String[] args) {
		Stack s  = new Stack();
		s.push("Patrick");
		s.push("Sponge Bob");
		s.push("Dwight Schrute");
		s.push("Jim Halpert");
		s.push("Pam Beasley");
		s.push("Tobey Flenderson");
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		
		
	}

}
