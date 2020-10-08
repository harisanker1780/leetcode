package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CostOfData {
	
	 public static void main(String args[] ) throws Exception {
		   
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();                // Reading input from STDIN
	        int N = Integer.parseInt(line);

	        TrieNode  root = new TrieNode(' ');
	        for(int k = 0; k < N; k++) {
	            String str = br.readLine().trim();
	            root.addWord(str);
	        }

	        System.out.println(root.getCount());
	 }
	 
	 static class TrieNode {
		 char c;
		 HashMap<Character, TrieNode> childrens;
		 
		 public TrieNode(char c) {
			 this.c = c;
			 this.childrens = new HashMap<>();
		 }
		 
		 public void addWord(String word) {
			 TrieNode root = this;
			 for(int i = 0; i < word.length(); i++) {
				 char c = word.charAt(i);
				 if(!root.childrens.containsKey(c)) {
					 root.childrens.put(c, new TrieNode(c));
				 }
				 
				 root = root.childrens.get(c);
			 }
		 }
		 
		 public int getCount() {
			 int count = 1;
			 for(char c : childrens.keySet()) {
				 count  += childrens.get(c).getCount(); 
			 }
			 return count;
		 }
	 }

}
