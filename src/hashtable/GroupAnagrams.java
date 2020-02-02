package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
    
		if(strs == null) {
			return null;
		}
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s : strs) {
			char[] array = s.toCharArray();
			Arrays.sort(array);
			
			String key = new String(array);
			List<String> list;
			if(map.containsKey(key)) {
				list = map.get(key);
			}
			else {
				list = new ArrayList<String>();
				map.put(key, list);
			}
			
			list.add(s);
		}
		
		List<List<String>> response = new ArrayList<List<String>>();
		Iterator<String> itr = map.keySet().iterator();
		while(itr.hasNext()) {
			List<String> list = map.get(itr.next());
			response.add(list);
		}
		
		return response;
    }
	
	public static void main(String[] args) {
		GroupAnagrams sol = new GroupAnagrams();
	}
	
	
}
