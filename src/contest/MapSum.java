package contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapSum {
	
	private Map<String, Integer> map;
	
	/** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        Iterator<String> itr = map.keySet().iterator();
        int sum = 0;
        while(itr.hasNext()) {
        	String key = itr.next();
        	if(key.startsWith(prefix)) {
        		sum = sum + map.get(key);
        	}
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
    	MapSum sol = new MapSum();
    	sol.insert("apple", 3);
    	System.out.println(sol.sum("ap"));// Output: 3
    	sol.insert("app", 2); // Output: Null
    	System.out.println(sol.sum("ap"));// Output: 5
	}
}
