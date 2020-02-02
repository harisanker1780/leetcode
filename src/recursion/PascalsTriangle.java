package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author haris
 *
 */
public class PascalsTriangle {
	
	 public List<List<Integer>> generate(int numRows) {
	        
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 
		 for(int i = 0; i < numRows; i++) {
			 list.add(new ArrayList<Integer>());
			 
			 int j = 0;
			 while(j <= i) {
				 list.get(i).add(f(i, j));
				 j++;
			 }
		 }
		 
		return list;
	 }

	 private int f(int i, int j) {
		 
		 if(j <= 0 || j == i)
			 return 1;
		 
		 return f(i - 1, j - 1) + f(i - 1, j); 
	 }
	 
	 public List<List<Integer>> generateOptimized(int numRows) {
		 List<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
		 
		 if(numRows > 0) {
			 
			 list.add(new ArrayList<Integer>(1));
			 
			 list.get(0).add(1);
			 
			 if(numRows > 1) {
				 
				 list.add(new ArrayList<Integer>(2));
				 
				 list.get(1).add(1);
				 list.get(1).add(1);
				 
				 for(int i = 2; i < numRows; i++) {
					 
					 list.add(new ArrayList<Integer>(i + 1));
					 
					 list.get(i).add(1);
					 
					 for(int j = 1; j < i; j++) {
						 list.get(i).add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1)); 
					 }
					 
					 list.get(i).add(1);
				 }
			 }
		 }
		 
		 return list;
	 }
}
