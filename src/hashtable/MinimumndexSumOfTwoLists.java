package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumndexSumOfTwoLists {
	
	
	public String[] findRestaurant(String[] list1, String[] list2) {
        
		if(list1 == null || list2 == null)
			return null;
		
		int minIndexSum = Integer.MAX_VALUE;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < list2.length; i++) {
			if(map.containsKey(list2[i])) {
				int indexSum = i + map.get(list2[i]);
				if(indexSum < minIndexSum) {
					result.clear();
					result.add(list2[i]);
					minIndexSum = indexSum;
				}
				else if(indexSum == minIndexSum) {
					result.add(list2[i]);
				}
			}
		}
		
		String[] array = new String[result.size()];
		return result.toArray(array);
    }
	
	public static void main(String[] args) {
		MinimumndexSumOfTwoLists sol = new MinimumndexSumOfTwoLists();
		/*String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
	    String[] s2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};*/
		String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
	    String[] s2 = {"KFC", "Shogun", "Burger King"};
	    System.out.println(Arrays.toString(sol.findRestaurant(s1, s2)));
	}
}
