package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		
        if(s == null || s.length() == 0)
        	return 0;
        
        int longestSubString = 0;
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        int lastReaptingIndex = 0;
        for(int i = 0; i < array.length; i++) {
        	
        	if(map.containsKey(array[i])) {
        		Integer j = map.get(array[i]);
        		if(j > lastReaptingIndex) {
        			lastReaptingIndex = j;
        		}
        		
        		count =  (i - lastReaptingIndex) - 1;
        	}
        	
        	count++;
        	if(count > longestSubString) {
    			longestSubString = count;
    		}
        	
        	map.put(array[i], i);
        }
        
        return longestSubString;
    }
	
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
		//System.out.println(sol.lengthOfLongestSubstring("dvdf"));
		System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
	}
}
