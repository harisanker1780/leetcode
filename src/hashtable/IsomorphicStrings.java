package hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	public boolean isIsomorphic(String s, String t) {
		return isIsomorphicUtil(s, t) && isIsomorphicUtil(t, s);
    }
	
	private boolean isIsomorphicUtil(String s, String t) {
		
		if(s == null || t == null)
			return true;
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if(map.containsKey(c1)) {
				if(map.get(c1) != c2) {
					return false;
				}
			}
			else {
				map.put(c1, c2);
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		IsomorphicStrings sol = new IsomorphicStrings();
		String  s = "egg", t = "add";
		//String s = "foo", t = "bar";
		//String s = "paper", t = "title";
		//String s = "ab", t = "aa";
		System.out.println(sol.isIsomorphic(s, t));
	}
}
