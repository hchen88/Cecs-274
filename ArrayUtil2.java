package project;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil2 {
	/**
	 * returns the index of the minimum element in the array, beginning at the given index
	 * @param a - the array of objects
	 * @param start -  the beginning of the tail of the array (i.e. where to start looking for min)
	 * @return
	 * 
	 */
	public static int minPosition(Object[] a, int start) {
		int p = start; //current min
		
		for (int i = start; i < a.length; i++) {
			if (((Comparable) a[i]).compareTo(a[p]) < 0) { // compareTo will return a negative integer if // a[i] < a[p]
				p = i;
			}
		}
		return p;
	}
	
	/**
	 * swapps the elements at the given in positions in the given array
	 * @param a - the array of Object data
	 * @param i - the index of the first element
	 * @param j - the index of the second element
	 */
	
	public static void swap(Object[] a, int i, int j) {
		
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	public static Object[] generateIntArray(int size, int maxVal) {
		Object[] a = new Object[size];
		Random r = new Random();
		for(int i = 0; i < size; i++) {
			a[i] = r.nextInt(maxVal); // generating a random integer in the range 0 to maxVal
		}
		return a;
	}
	
	public static Object[] generateDoubleArray (int size) {
		Object[] a = new Object[size];
		Random r = new Random();
		for(int i = 0; i < size; i++) {
			a[i] = r.nextDouble(); // generating a random integer in the range 0 to maxVal
		}
		return a;
	}
	public static void main(String[] args) {
		Object[] x = {91,-100, -23, -50, 39};
		Object[] y = {"Z" , "T", "A", "C", "D"};
		System.out.println(minPosition(x,2));
		System.out.println("Expected: 3");
		System.out.println(minPosition(y, 2));
		System.out.println("Expected: 2");
		
		System.out.println("Before swap: " + Arrays.toString(y));
		
		swap(y, 1, 3);
		System.out.println("After swap: " + Arrays.toString(y));
		
		Object[] ran = generateIntArray(5,50);
		System.out.println(Arrays.toString(ran));
	}
}
