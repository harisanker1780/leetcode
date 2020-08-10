package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Design a data structure that supports all following operations in average O(1) time.

 

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 

Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 *
 */
public class RandomizedSet {
	
	 Map<Integer, Integer> map;
	 ArrayList<Integer> list;

	 public RandomizedSet() {
		 map = new HashMap<Integer, Integer>();
		 list = new ArrayList<Integer>();
	 }
	    
	 /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	 public boolean insert(int val) {
        if(!map.containsKey(val)) {
        	map.put(val, list.size());
        	list.add(val);
        	return true;
        } else {
        	return false;
        }
	 }
	    
	 /** Removes a value from the set. Returns true if the set contained the specified element. */
	 public boolean remove(int val) {
	      if(map.containsKey(val)) {
	    	  int index = map.get(val);
	    	  
	    	  int last = list.get(list.size() - 1);
	    	  Collections.swap(list, list.size() - 1, index);
	    	  list.remove(list.size() - 1);
	    	  map.remove(val);
	    	  
	    	  if(list.size() > 0) {
	    		  map.put(last, index);
	    	  }
	    	  
	    	  return true;
	      }
	      
	      return false;
	 }
	    
	 /** Get a random element from the set. */
	 public int getRandom() {
		 Random rand = new Random();
		 int index = rand.nextInt(list.size()); 
		 return list.get(index);
	 }
	 
	 public static void main(String[] args) {
		// Init an empty set.
		 RandomizedSet randomSet = new RandomizedSet();

		 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
		 System.out.println(randomSet.insert(0));

		 // Returns false as 2 does not exist in the set.
		 System.out.println(randomSet.insert(1));

		 // Inserts 2 to the set, returns true. Set now contains [1,2].
		 System.out.println(randomSet.remove(0));

		 // getRandom should return either 1 or 2 randomly.
		 System.out.println(randomSet.insert(2));

		 // Removes 1 from the set, returns true. Set now contains [2].
		 System.out.println(randomSet.remove(1));

		 // 2 was already in the set, so return false.
		//System.out.println(randomSet.insert(2));

		 // Since 2 is the only number in the set, getRandom always return 2.
		 System.out.println(randomSet.getRandom());
	 }
}
