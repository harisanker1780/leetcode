package test;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithDuplicates {
	
	public static void main(String[] args) {
		ArrayList<String> result = getPerms("aabc");
		for(String s : result) {
			System.out.println(s);
		}
	}
	
	private static ArrayList<String> getPerms(String s) {
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		getPerms(map, "", s.length(), result);
		return result;
	}
	
	private static void getPerms(HashMap<Character, Integer> map, String prefix, int remainder, ArrayList<String> result) {
		if(remainder == 0) {
			result.add(prefix);
			return;
		}
		
		for(Character c : map.keySet()) {
			int count = map.get(c);
			if(count > 0) {
				map.put(c, count - 1);
				getPerms(map, prefix + c, remainder - 1, result);
				map.put(c, count);
			}
		}
	}
	
	private static HashMap<Character, Integer> buildFreqTable(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : s.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 0);
			}
			
			map.put(c, map.get(c) + 1);
		}
		
		return map;
	}

}
