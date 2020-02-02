package binarysearch;

public class BinarySearch {
	
	 public int search(int[] nums, int target) {
		 if(nums == null)
			 return -1;
		 return search(nums, target, 0, nums.length - 1);
	 }

	 private int search(int[] nums, int target, int left, int right) {
		 if(left > right)
			 return -1;
		 
		 int mid = left + ((right - left) / 2);
		 if(nums[mid] == target) {
			 return mid;
		 }
		 else if(target > nums[mid]) {
			 return search(nums, target, mid + 1, right);
		 }
		 else {
			 return search(nums, target, left, mid - 1);
		 }
	 }
	 
	 public static void main(String[] args) {
		 BinarySearch sol = new BinarySearch();
		/* int[] nums = {-1,0,3,5,9,12};
		 int target = 9;*/
		 
		 int[] nums = {-1,0,3,5,9,12};
		 int target = 2;
		 
		 System.out.println(sol.search(nums, target));
	 }
}
