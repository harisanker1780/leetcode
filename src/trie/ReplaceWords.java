package trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 

Note:

The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
 *
 */
public class ReplaceWords {
	
	public String replaceWords(List<String> dict, String sentence) {
        
		if(sentence == null)
        	return null;
		
		if(sentence.trim().length() == 0)
        	return sentence;
        
        sentence = sentence.trim();
        Trie trie = new Trie();
        
        if(dict != null) {
        	for(String s : dict) {
        		trie.insert(s);
        	}
        }
        
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        
        for(String word : words) {
        	word = word.trim();
        	if(word.length() > 0) {
        		char[] chars = word.toCharArray();
            	StringBuilder wordBuilder = new StringBuilder();
            	boolean hasRoot = false;
            	for(char c : chars) {
            		wordBuilder.append(c);
            		if(trie.search(wordBuilder.toString())) {
            			builder.append(wordBuilder.toString());
            			builder.append(" ");
            			hasRoot = true;
            			break;
            		}
            	}
            	
            	if(!hasRoot) {
            		builder.append(word);
            		builder.append(" ");
            	}
        	}
        }
        
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

	
	class Trie {
		
		private TrieNode root;
		
		/** Initialize your data structure here. */
	    public Trie() {
	    	root = new TrieNode(null);
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        if(word != null) {
	        	word = word.trim();
	        	if(word.length() > 0) {
	        		char[] array = word.toCharArray();
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
	            	
	            	node.isLeafNode = true;
	        	}
	        }
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	    	 if (word != null) {
	    		char[] array = word.toCharArray();
	         	TrieNode node = root;
	         	for(char c : array) {
	         		if(node.children.containsKey(c)) {
	         			node = node.children.get(c);
	         		} else {
	         			return false;
	         		}
	         	}
	         	
	         	return node.isLeafNode;
	    	 }
	    	 
	    	 return false;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	    	 if (prefix != null) {
	     		char[] array = prefix.toCharArray();
	          	TrieNode node = root;
	          	for(char c : array) {
	          		if(node.children.containsKey(c)) {
	          			node = node.children.get(c);
	          		} else {
	          			return false;
	          		}
	          	}
	          	
	          	return true;
	     	 }
	     	 
	     	 return false;
	    }
	    
	    class TrieNode {
	    	public Character c;
	    	public boolean isLeafNode;
	        public Map<Character, TrieNode> children = new HashMap<>();
	        
	        public TrieNode(Character c) {
	        	this.c = c;
	        }
	    };
	}
	
	public static void main(String[] args) {
		ReplaceWords sol = new ReplaceWords();
		String[] array = {"cat", "bat", "rat"};
		List<String> dic = Arrays.asList(array);
		System.out.println(sol.replaceWords(dic, ""));
	}
}
