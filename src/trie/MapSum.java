package trie;

import java.util.HashMap;
import java.util.Map;

import trie.Trie.TrieNode;

/**
 * Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 *
 */
public class MapSum {
	
	private TrieNode root;
	
	/** Initialize your data structure here. */
    public MapSum() {
    	root = new TrieNode(null);
    }
    
    public void insert(String key, int val) {
    	if (key != null) {
    		key = key.trim();
        	if(key.length() > 0) {
        		char[] array = key.toCharArray();
             	TrieNode node = root;
             	for(char c : array) {
             		if(node.children.containsKey(c)) {
             			node = node.children.get(c);
             		} else {
             			TrieNode child = new TrieNode(c);
            			node.children.put(c, child);
            			node = child;
             		}
             	}
             	
             	node.val = val;
        	}
    	 }
    }
    
    public int sum(String prefix) {
        
    	int sum = 0;
        
        if(prefix != null) {
        	prefix = prefix.trim();
        	if(prefix.length() > 0) {
        		char[] array = prefix.toCharArray();
             	TrieNode node = root;
             	for(char c : array) {
             		if(node.children.containsKey(c)) {
             			node = node.children.get(c);
             		} else {
             			return 0;
             		}
             	}
             	
             	sum = sum(node);
        	}
    	}
        
        return sum;
    }
    
    private int sum(TrieNode node) {
    	int sum = node.val != null ? node.val : 0;
    	if(node.children.size() > 0) {
    		for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
         		sum = sum + sum(entry.getValue());
         	}
    	}
    	
    	return sum;
    }

    class TrieNode {
    	public Character c;
    	public Integer val;
        public Map<Character, TrieNode> children = new HashMap<>();
        
        public TrieNode(Character c) {
        	this.c = c;
        }
    };
    
    public static void main(String[] args) {
    	MapSum sol = new MapSum();
    	sol.insert("apple", 3);
    	System.out.println(sol.sum("ap"));
    	sol.insert("app", 2);
    	System.out.println(sol.sum("ap"));

	}
}
