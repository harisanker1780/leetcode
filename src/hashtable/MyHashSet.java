package hashtable;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
	
	private final int NUMBER_OF_BUCKETS = 10000;
	
	private Bucket[] buckets;
	
	/** Initialize your data structure here. */
    public MyHashSet() {
    	buckets = new Bucket[NUMBER_OF_BUCKETS];
    }
    
    public void add(int key) {
        int hash = hash(key);
        Bucket bucket = buckets[hash];
        if(bucket == null) {
        	bucket = new Bucket();
        	buckets[hash] = bucket;
        }
        bucket.add(key);
    }
    
    public void remove(int key) {
    	int hash = hash(key);
    	Bucket bucket = buckets[hash];
    	if(bucket != null) {
    		bucket.remove(key);
    	}
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	int hash = hash(key);
    	Bucket bucket = buckets[hash];
    	return (bucket != null && bucket.contains(key));
    }
    
    private int hash(int key) {
    	return key % NUMBER_OF_BUCKETS;
    }
    
    class Bucket {
    	
    	private List<Integer> values;
    	
    	public Bucket() {
    		this.values = new ArrayList<Integer>();
    	}
    	
    	public void add(int key) {
    		if(!values.contains(key)) {
    			values.add(key);
    		}
    	}
    	
    	public void remove(int key) {
    		if(values.contains(key)) {
    			values.remove(values.indexOf(key));
    		}
    	}
    	
    	public boolean contains(int key) {
    		return values.contains(key);
    	}
    }
    
    public static void main(String[] args) {
    	MyHashSet hashSet = new MyHashSet();
    	hashSet.add(1);         
    	hashSet.add(2);         
    	System.out.println(hashSet.contains(1));    // returns true
    	System.out.println(hashSet.contains(3));    // returns false (not found)
    	hashSet.add(2);          
    	System.out.println(hashSet.contains(2));    // returns true
    	hashSet.remove(2);          
    	System.out.println(hashSet.contains(2));    // returns false (already removed)
	}
}
