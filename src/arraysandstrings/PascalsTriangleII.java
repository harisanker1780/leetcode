package arraysandstrings;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
	
	public List<Integer> getRow(int rowIndex) {
        
		if(rowIndex < 0)
			return null;
		
		Integer[] array = new Integer[rowIndex + 1];
		int i = 0;
		while(i <= rowIndex) {
			array[0] = 1;
			array[i] = 1;
			
			Integer prev = null;
			for(int j = 1; j < i; j++) {
				if(prev == null)
				{
					prev = array[j - 1];
				}
				
				int sum = array[j] + prev;
				prev = array[j];
				array[j] = sum;
			}
			
			i++;
		}
	
		return Arrays.asList(array);
    }
	
	public static void main(String[] args) {
		PascalsTriangleII sol = new PascalsTriangleII();
		List<Integer> list = sol.getRow(3);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
