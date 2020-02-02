package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
	
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while(true) {
			
			if(n == 1) {
				return true;
			}
			
			int squareSum = digitSquareSum(digits(n));
			
			if(set.contains(squareSum)) {
				return false;
			}
			else {
				set.add(squareSum);
			}
			
			n = squareSum;
		}
    }
	
	private int digitSquareSum(List<Integer> digits) {
		if(digits == null)
			return 0;
		
		int sum = 0;
		for(int i = 0; i < digits.size(); i++) {
			sum = sum + (digits.get(i) * digits.get(i));
		}
		
		return sum;
	}
	
	private List<Integer> digits(int num) {
		List<Integer> result = new ArrayList<Integer>();
		while(Math.abs(num) > 0) {
			int d = num % 10;
			result.add(d);
			num = num / 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		HappyNumber sol = new HappyNumber();
		System.out.println(sol.isHappy(19));
	}
}
