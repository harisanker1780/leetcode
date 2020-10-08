package hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxNum1 {
	
	public static void main(String[] args) throws Exception {
		//int[] nums = {1, 1, 1, 2};
		//System.out.println(findMaxNum(nums, 1));
		int[] nums = {16, 12, 4};
		int sum = 0;
		for(int num : nums) {
			sum += num & 92;
		}
		
		System.out.println(sum);
	}
	
	private static int findMaxNum(int[] nums, int l) {
		
		List<Pos> positions = new ArrayList<Pos>();
		
		for(int num : nums) {
			int s = 0;
			while(num > 0) {
				
				if(positions.size() <= s) {
					positions.add(new Pos((int)Math.pow(2, s)));
				}
				
				if((num & 1) == 1) {
					positions.get(s).incrementCount();
				}
				num = num >> 1;
				s++;
			}
		}
		
		Collections.sort(positions, new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				if(o1.getValue() < o2.getValue()) {
					return 1;
				} else if(o1.getValue() > o2.getValue()) {
					return -1;
				} else { 
					return 0;
				}
			}
		});
		
		
		int i = 0;
		while(l > 0 && i < positions.size() && positions.get(i).getValue() > 0) {
			int count = 0;
			int prev = positions.get(i).getValue();
			while(i < positions.size() && positions.get(i).getValue() == prev) {
				count++;
				i++;
			}
			
			if(count >= l) {
				return combinations(count, l);
			} else {
				 l = l - count;
			}
		}
		
		return l > 0 ? -1 : 1;
	}
	
	private static int combinations(int n, int r) {
		return factorial(n) / (factorial(r) * (factorial(n - r)));
	}
	
	private static int factorial(int n) {
		if(n <= 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	
	static class Pos {
		private final int baseVal;
		private int count = 0;
		
		public Pos(int baseVal) {
			this.baseVal = baseVal;
		}
		
		public void incrementCount() {
			this.count++;
		}
		
		public int getValue() {
			return count * baseVal;
		}
	}
}
