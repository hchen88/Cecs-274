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
			sorted = true;
			for( int i= 1 ; i < a.length; i++) {
					if (((Comparable) a[i]).compareTo(a[i-1]) < 0) {
						sorted = false;
						temp = a[i-1];
						a[i-1] = a[i];
						a[i] = temp;
						//System.out.println("Change: " + Arrays.toString(a));
					}
			}
				
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
		System.out.println("Generating Random Arrays with size starting at 10000");
		int size = 0;
		int totalTime = 0;
		for (int i = 0; i < 6; i++) {
			size += 10000;
			a = ArrayUtil2.generateDoubleArray(size);
			s.start();
			sort(a);
			s.stop();
			System.out.println("size: " + size  + "\ttime elapased: " + s.getMilliSecondsElapsed() + " milliseconds");
			s.reset();
		}
		System.out.println("DONE");
		
		
	}
	
	
}
