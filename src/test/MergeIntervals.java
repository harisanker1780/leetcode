package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 

Constraints:

intervals[i][0] <= intervals[i][1]
 *
 */
public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
        
		// Space : O(n)
		Node[] list = new Node[intervals.length];
		
		// Time: O(n)
		for(int i = 0; i < intervals.length; i++) {
			int[] interval = intervals[i];
			Node node = new Node(interval[0], interval[1]);
			list[i] = node;
		}
		
		// Time:  O(n log n)
		Arrays.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.start < o2.start) {
					return -1;
				} else if(o1.start > o2.start) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		// Time: O(n)
		int mergedCount = 0;
		for(int i = 1; i < list.length; i++) {
			Node thisNode = list[i];
			Node prevNode = list[i - 1];
			if(thisNode.canMerge(prevNode)) {
				thisNode.merge(prevNode);
				list[i - 1] = null;
				mergedCount++;
			}
		}
		
		int[][] result = new int[list.length - mergedCount][2];
		int j = 0;
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				result[j++] = new int[] {list[i].start, list[i].end};
			}
		}
		
		return result;
    }
	
	class Node {
		public int start;
		public int end;
		
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public boolean canMerge(Node other) {
			
			if(this.end == other.end)
				return true;
			
			Node max, min;
			if(this.end >= other.end) {
				max = this;
				min = other;
			} else {
				max = other;
				min = this;
			}
			
			return min.end >= max.start;
		}
		
		public void merge(Node other) {
			this.start = Math.min(this.start, other.start);
			this.end = Math.max(this.end, other.end);
		}
	}
	
	public static void main(String[] args) {
		MergeIntervals sol = new MergeIntervals();
//		int[][] input = {
//				{1,3},
//				{2,6},
//				{8,10},
//				{15,18}
//		};
		
//		int[][] input = {
//				{1, 4},
//				{4, 5}
//		};
		
		int[][] input = {
				{1, 1},
				{1, 2},
				{2, 5}
		};
		
		int[][] result = sol.merge(input);
		for(int[] r: result) {
			System.out.println(Arrays.toString(r));
		}
	}
}
