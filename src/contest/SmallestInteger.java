package contest;

import java.util.HashSet;
import java.util.Set;

public class SmallestInteger {
	
	 public int solution(int[] A) {
		 
		 int MAX_VAL = 1000000;
		 
		 Set<Integer> set = new HashSet<Integer>();
		 for(int i = 0; i < A.length; i++) {
			if(A[i] > 0) {
				set.add(A[i]); 
			}
		 }
		 
		 for(int i = 1; i <= MAX_VAL; i++) {
			 if(!set.contains(i)) {
				 return i;
			 }
		 }
		 
		 return MAX_VAL + 1;
	 }
	 
	public static void main(String[] args) {
		SmallestInteger sol = new SmallestInteger();
		//int[] input = {1, 3, 6, 4, 1, 2};
		//int[] input = {1, 2, 3};
		int[] input = {-1, -3};
		System.out.println(sol.solution(input));
	}
}
