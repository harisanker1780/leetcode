package epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyIntegers {
	
	public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
		
		final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
		
		num1.set(0, Math.abs(num1.get(0)));
		num2.set(0, Math.abs(num2.get(0)));
		
		int size = num1.size() + num2.size();
		List<Integer> result =  new ArrayList<Integer>(size);
		
		List<Integer> first = null, second = null;
		
		if(num1.size() > num2.size()) {
			first = num1;
			second = num2;
		}
		else {
			first = num2;
			second = num1;
		}
		
		for(int i = 0; i < size; i++) {
			result.add(i, 0);
		}
		
		int carry = 0;
		int rIndex = size - 1;
		for(int i = second.size() - 1; i >= 0; i--) {
			int k = rIndex;
			for(int j = first.size() - 1; j >= 0; j--) {
				 
				int r = second.get(i) * first.get(j) + carry;
				if(r > 9) {
					carry = r / 10;
					r = r - (carry * 10); 
				}
				else {
					carry = 0;
				}
				
				result.set(k, result.get(k) + r);
				k--;
			}
			
			if(carry > 0) {
				result.set(k, carry);
				carry = 0;
			}
			
			rIndex--;
		}
		
		//Remove leading zeros
		int firstNonZeroRow = 0;
		while(firstNonZeroRow < result.size() && result.get(firstNonZeroRow) == 0) {
			firstNonZeroRow++;
		}
		result = result.subList(firstNonZeroRow, result.size());
		
		if(!result.isEmpty()) {
			result.set(0, result.get(0) * sign);
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> num1 = new ArrayList<Integer>();
		List<Integer> num2 = new ArrayList<Integer>();
		
		num1.add(0, 1);
		num1.add(1, 1);
		num1.add(2, 1);
		
		num2.add(0, 1);
		num2.add(1, 1);
		num2.add(2, 1);
		
		List<Integer> result = multiply(num1, num2);
		System.out.println(Arrays.toString(result.toArray()));
	}

}
