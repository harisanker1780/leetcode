package test;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 <= k <= array's length.
 *
 */
public class KthLargestElementInAnArray {

	public int findKthLargest(int[] nums, int k) {
        
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
			if(queue.size() > k) {
				queue.poll();
			}
		}
		
		return queue.poll();
    }
	
	public static void main(String[] args) {
		KthLargestElementInAnArray sol = new KthLargestElementInAnArray();
		int[] input = {3,2,3,1,2,4,5,5,6};
		System.out.println(sol.findKthLargest(input, 2));
	}
}