package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001 
 *
 */
public class KthSymbolInGrammar {
	
	 public int kthGrammar(int N, int K) {
		   List<Integer> array = new ArrayList<>();
	       generateGrammer(N, array);
	       return array.get(K -1);
	 }
	 
	 private void generateGrammer(int N, List<Integer> array) {
		 if(N == 1) {
			 add(array, 0, 0);
		 }
		 else {
			 generateGrammer(N - 1, array);
			 
			 int prevEnd = (int) (Math.pow(2, N - 2) - 1);
			 int currentEnd = (int) (Math.pow(2, N - 1) - 1);
			 for(int i = prevEnd; i >= 0; i--) {
				 if(array.get(i) == 0) {
					 add(array, currentEnd - 1, 0);
					 add(array, currentEnd, 1);
					 currentEnd = currentEnd - 2;
				 } else {
					 add(array, currentEnd - 1, 1);
					 add(array, currentEnd, 0);
					 currentEnd = currentEnd - 2;
				 }
			 }
		 }
	 }
	 
	 private void add(List<Integer> array, int index,  int val) {
		 if(array.size() <= index) {
			 while(array.size() < index) {
				 array.add(-1);
			 }
			 array.add(index, val);
		 }
		 else {
			 array.set(index, val);
		 }
	 }

	public static void main(String[] args) {
		KthSymbolInGrammar sol = new KthSymbolInGrammar();
		System.out.println(sol.kthGrammar(30, 4349));
		
//		int a [] = new int[434991989];
//		System.out.println(Math.pow(2, 29));
	}
}
