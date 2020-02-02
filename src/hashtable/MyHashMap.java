package hashtable;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
	
	private final int NUMBER_OF_BUCKETS = 10000;
	
	private Bucket[] buckets;
	
	 /** Initialize your data structure here. */
    public MyHashMap() {
    	buckets = new Bucket[NUMBER_OF_BUCKETS];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	 int hash = hash(key);
         Bucket bucket = buckets[hash];
         if(bucket == null) {
         	bucket = new Bucket();
         	buckets[hash] = bucket;
         }
         bucket.add(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	int hash = hash(key);
    	Bucket bucket = buckets[hash];
    	if(bucket != null) {
    		return bucket.get(key);
    	}
    	return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int hash = hash(key);
    	Bucket bucket = buckets[hash];
    	if(bucket != null) {
    		bucket.remove(key);
    	}
    }
    
    private int hash(int key) {
    	return key % NUMBER_OF_BUCKETS;
    }
    
    class Bucket {
    	
    	private List<Item> values;
    	
    	public Bucket() {
    		this.values = new ArrayList<Item>();
    	}
    	
    	public void add(int key, int value) {
    		Item item = new Item(key, value); 
    		if(!values.contains(item)) {
    			values.add(item);
    		}
    		else {
    			item = values.get(values.indexOf(item));
    			item.value = value;
    		}
    	}
    	
    	public void remove(int key) {
    		Item item = new Item(key);
    		if(values.contains(item)) {
    			values.remove(values.indexOf(item));
    		}
    	}
    	
    	public int get(int key) {
    		Item item = new Item(key);
    		if(values.contains(item)) {
    			item = values.get(values.indexOf(item));
    			return item.value;
    		}
    		return -1;
    	}
    }
    
    class Item {
    	
    	int key, value;
    	
    	public Item(int key) {
    		this.key = key;
    	}
    	
    	public Item(int key, int value) {
    		this.key = key;
    		this.value = value;
    	}
    	
    	public boolean equals(Object obj) {
    		if(this == obj) {
    			return true;
    		}
    		
    		if(obj instanceof Item) {
    			Item other = (Item) obj;
    			return this.key == other.key;
    		}
    		
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	MyHashMap hashMap = new MyHashMap();
    	hashMap.put(1, 1);          
    	hashMap.put(2, 2);         
    	System.out.println(hashMap.get(1));            // returns 1
    	System.out.println(hashMap.get(3));            // returns -1 (not found)
    	hashMap.put(2, 1);          // update the existing value
    	System.out.println(hashMap.get(2));            // returns 1 
    	hashMap.remove(2);          // remove the mapping for 2
    	System.out.println(hashMap.get(2));            // returns -1 (not found) 
	}
    
}
