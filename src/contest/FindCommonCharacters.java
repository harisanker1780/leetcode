package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
	
	public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();
        
        if(A == null || A.length == 0)
        	return result;
        
        Map<Character, Integer> prev = null;
        for(int i = 0; i < A.length; i++) {
        	char array[] = A[i].toCharArray();
        	Map<Character, Integer> map = new HashMap<Character, Integer>();
        	for(char c : array) {
        		if(map.containsKey(c)){
        			int v = map.get(c);
        			v = v + 1;
        			if(prev != null) {
        				if(prev.containsKey(c)) {
        					int v1 = prev.get(c);
        					v = Math.min(v, v1);
        				}
        			}
        			
        			map.put(c, v);
        		}
        		else{
        			if(prev == null || prev.containsKey(c)) {
        				map.put(c, 1);
        			}
        		}
        	}
        	
        	prev = map;
        }
        
        Iterator<Character> itr = prev.keySet().iterator();
        while(itr.hasNext()) {
        	char c = itr.next();
        	int count = prev.get(c);
        	while(count > 0) {
        		result.add(c + "");
        		count--;
        	}
        }
        
        return result;
    } 
	
	public static void main(String[] args) {
		FindCommonCharacters sol = new FindCommonCharacters();
		String[] A = {};
		sol.commonChars(A);
	}
}
