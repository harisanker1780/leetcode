package recursion;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
 *
 *Example:

Input: [2,1,5,6,2,3]
Output: 10
 */
public class LargestRectangleInHistogram {
	
	public int largestRectangleArea(int[] heights) {
		if(heights != null && heights.length > 0) {
			int maxArea = heights[0];
			for(int i = 0; i < heights.length; i++) {
				int min = heights[i];
				for(int j = i; j < heights.length; j++) {
					if(heights[j] < min) {
						min = heights[j];
					}
					
					int area = ((j - i) + 1) * min;
					if(area > maxArea) {
						maxArea = area;
					}
				}
			}
			
			return maxArea;
		} else {
			return 0;
		}
    }
	
	private int area(int[] heights, int start, int end, int minMatrix[][]) {
		
		if(start >= end) {
			return heights[start];
		}
		
		int min = minMatrix[start][end];
		int area = ((end - start) + 1) * min;
		return max(area, area(heights, start, end - 1, minMatrix), area(heights, start + 1, end, minMatrix),
				area(heights, start + 1, end - 1, minMatrix));
	}
	
	private int max(int ...a) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max)
				max = a[i];
		}
		
		return max;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram sol = new LargestRectangleInHistogram();
		int[] heights = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
		//int[] heights = {2,1,5,6,2,3};
		//int[] heights = {0, 9};
		//int[] heights = {};
		System.out.println(sol.largestRectangleArea(heights));
	}
}
