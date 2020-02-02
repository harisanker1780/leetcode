package epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncrementInteger {
	
	public static List<Integer> plusOne(List<Integer> a)
	{
		int carry = 1;
		for(int i = a.size() - 1; i >= 0; i--) {
			int sum = a.get(i) + carry;
			if(sum == 10) {
				a.set(i, 0);
			}
			else {
				a.set(i, sum);
				carry = 0;
			}
		}
		
		if(carry == 1) {
			a.set(0, 0);
			a.add(0, 1);
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(0, 9);
		a.add(1, 9);
		a.add(2, 9);
		a.add(3, 9);
		a.add(4, 9);
		a.add(5, 9);
		a.add(6, 9);
		a.add(7, 9);
		a.add(8, 9);
		a.add(9, 9);
		a.add(10, 9);
		a.add(11, 9);
		a.add(12, 9);
		a.add(13, 9);
		a.add(14, 9);
		a.add(15, 9);
		a.add(16, 9);
		a.add(17, 9);
		a.add(18, 9);
		a.add(19, 9);
		a.add(20, 9);
		a.add(21, 9);
		a.add(22, 9);
		a.add(23, 9);
		
		System.out.println(Arrays.toString(a.toArray()));
		System.out.println(Arrays.toString(plusOne(a).toArray()));
	}

}
