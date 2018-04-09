package project;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public BubbleSort() {
		
	}
	
	public static void sort(Object[] a) {
		/**
		 * While the array is not sorted
		 * For each adjacent pair of elements
		 * If the pair is not sorted
		 * Swap its elements.
		 * 
		 */
		Object temp = 0;
		
		boolean sorted = false;
		while( !sorted) {
			for( int i= 0 ; i < a.length; i++) {
				for(int j =1 ; j < a.length; j++) {
					if (((Comparable) a[j-1]).compareTo(a[j]) > 0) {
						temp = a[j-1];
						a[j-1] = a[j];
						a[j] = temp;
						//System.out.println("Change: " + Arrays.toString(a));
					}
				}
				
			}
			sorted = true;
		}
				
	}
	public static void main(String[] args) {
		StopWatch s = new StopWatch();
		Object[] a = { 6.1, 4.2, 3.3, 7.4, 5.5, 2.6, 8.7, 1.8};
		
		Scanner in = new Scanner(System.in);
		String sizeString;
		
		System.out.println( "Old array " + Arrays.toString(a));
		
		sort(a);
		
		System.out.println("New array" + Arrays.toString(a));
		
		System.out.println("Please Enter Size of Array to sort: ");
		sizeString = in.nextLine().trim();
		int size = Integer.parseInt(sizeString);
		for (int i = 0; i <= 8; i++) {
			a = ArrayUtil2.generateDoubleArray(size);
			s.start();
			sort(a);
			s.stop();
			System.out.println("size: " + size + "\ttime elapased: " + s.getMilliSecondsElapsed() + " milliseconds");
			s.reset();
		}
		
		
	}
	
	
}
