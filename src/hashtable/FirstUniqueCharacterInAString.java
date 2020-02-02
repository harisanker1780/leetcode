package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
    
		if(s == null)
			return -1;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] array = s.toCharArray();
		for(int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				int count = map.get(array[i]);
				map.put(array[i], count + 1);
			}
			else {
				map.put(array[i], 1);
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			int count = map.get(array[i]);
			if(count == 1) {
				return i;
			}
		}
		
		return -1;
    }
	
	public int firstUniqChar1(String s) {
	    
		if(s == null)
			return -1;
		
		Set<Character> set = new HashSet<Character>();
		char[] array = s.toCharArray();
		int index = -1;
		for(int i = array.length - 1; i >= 0; i--) {
			if(!set.contains(array[i])) {
				index = i;
				set.add(array[i]);
			}
			else {
				if(index != -1 && array[i] == array[index]) {
					index = -1;
				}
			}
		}
		
		return index;
    }
	
	public static void main(String[] args) {
		FirstUniqueCharacterInAString sol = new FirstUniqueCharacterInAString();
		String s = "leetcode";
		//String s = "loveleetcode";
		System.out.println(sol.firstUniqChar1(s));
	}
}
