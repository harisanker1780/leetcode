package arraysandstrings;

public class TwoSumIIInputArrayisSorted {
	
	public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
        	if(numbers[i] + numbers[j] == target) {
        		return new int[] {i + 1, j + 1};
        	}
        	else if(numbers[i] + numbers[j] > target) {
        		j--;
        	}
        	else {
        		i++;
        	}
        }
        
        return null;
    }
	
	public static void main(String[] args) {
		TwoSumIIInputArrayisSorted sol = new TwoSumIIInputArrayisSorted();
		int[] numbers = {2,7,11,15};
		int target = 9;
		int[] r = sol.twoSum(numbers, target);
		System.out.println(r[0]);
		System.out.println(r[1]);
	}
}
