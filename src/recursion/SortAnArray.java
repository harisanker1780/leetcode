package recursion;

import java.util.ArrayList;
import java.util.List;

public class SortAnArray {
	
    public List<Integer> sortArray(int[] nums) {
    	mergeSort(nums, 0, nums.length - 1);
    	List<Integer> result = new ArrayList<>(nums.length);
    	for(int n : nums) {
    		result.add(n);
    	}
    	return result; 
    }

    private void mergeSort(int[] nums, int start, int end) {
    	if(start < end) {
    		int mid = (start + end) / 2;
    		mergeSort(nums, start, mid);
    		mergeSort(nums, mid + 1, end);
    		merge(nums, start, mid, end);
    	}
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
    	int aux[] = new int[nums.length];
    	for(int i = start; i <= end; i++) {
    		aux[i] = nums[i];
    	}
    	
    	int m = start;
    	int n = mid + 1;
    	for(int i = start; i <= end; i++) {
    		if(m > mid) {
    			nums[i] = aux[n++];
    		}
    		else if(n > end ) {
    			nums[i] = aux[m++];
    		}
    		else {
    			if(aux[m] < aux[n]) {
    				nums[i] = aux[m++];
    			}
    			else {
    				nums[i] = aux[n++];
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	SortAnArray sol = new SortAnArray();
    	int[] nums = {5,1,1,2,0,0};
    	List<Integer> result = sol.sortArray(nums);
    	for(Integer r : result) {
    		System.out.print(r + ", ");
    	}
	}
}
