package stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TargetSum {
	
	public int findTargetSumWays(int[] nums, int S) {
		short[] operators = new short[nums.length];
		Set<Integer> visited = new HashSet<Integer>();
		return targetSum(nums, operators, S, 0, visited);
    }
	
	private int targetSum(int[] nums, short[] operators, int S, int index, Set<Integer> visited) {
		int ways = 0;
		if(sum(nums, operators) == S) {
			ways = 1;
			System.out.println(Arrays.toString(operators));
		}
		
		if(index < operators.length) {
			operators[index] = 1;
			if(!visited.contains(operatorValue(operators))) {
				visited.add(operatorValue(operators));
				ways = ways + targetSum(nums, operators, S, index + 1, visited);
			}
			
			
			operators[index] = 0;
			if(!visited.contains(operatorValue(operators))) {
				visited.add(operatorValue(operators));
				ways = ways + targetSum(nums, operators, S, index + 1, visited);
			}
		}
		
		return ways;
	}
	
	private int sum(int[] nums, short[] operators) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			int value = (operators[i] == 1) ? 1 : -1;
			sum = sum + (nums[i] * value);
		}
		
		return sum;
	}
	
	private int operatorValue(short[] operators) {
		int base = 0;
		int value = 0;
		for(int i = 0; i < operators.length; i++) {
			if(operators[i] == 1) {
				value = (int) (value + Math.pow(2, base));
			}
			
			base++;
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		TargetSum t = new TargetSum();
		System.out.println(t.findTargetSumWays(nums, 3));
	}
}
