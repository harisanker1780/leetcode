package epi.arrays;

import java.util.Arrays;

public class EvenOdd {
	
	public static void evenOdd(int a[]) {
		int evenIndex = 0;
		for(int i = 0; i < a.length; i++) {
			if(isEven(a[i])) {
				swap(a, i, evenIndex);
				evenIndex++;
			}
		}
	}

	private static void swap(int[] a, int i, int evenIndex) {
		int temp = a[i];
		a[i] = a[evenIndex];
		a[evenIndex] = temp;
	}

	private static boolean isEven(int i) {
		return i % 2 == 0;
	}
	
	public static void main(String[] args) {
		int a[] = {1, 3, 5, 8, 9, 10, 5, 1, 6, 22};
		evenOdd(a);
		System.out.println(Arrays.toString(a));
	}

}
