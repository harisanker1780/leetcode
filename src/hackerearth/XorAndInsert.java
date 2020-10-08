package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class XorAndInsert {

	public static void main(String[] args) throws Exception {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String line = br.readLine();                // Reading input from STDIN
	     int Q = Integer.parseInt(line);
	     
	     TrieNode root = new TrieNode(' ');
	     root.addNumber(prependZero(Integer.toBinaryString(0), 31));
	     
	     ArrayList<Integer> list;
	     
	     for(int i = 0; i < Q; i++) {
	    	 String[] str = br.readLine().split(" ");
	    	 int type = Integer.parseInt(str[0]);
	    	 
	    	 if(type == 1) {
	    		 int val = Integer.parseInt(str[1]);
	    		 String binary = prependZero(Integer.toBinaryString(val), 31);
	    		 root.addNumber(binary);
	    	 } else if(type == 2) {
	    		 int val = Integer.parseInt(str[1]);
	    		 String binary = prependZero(Integer.toBinaryString(val), 31);
	    		 root.xorAll(binary, 0);
	    	 } else if(type == 3) {
	    		 StringBuilder builder = new StringBuilder();
	    		 root.getMinimum(builder);
	    		 
	    		 String binary = builder.toString().trim();
	    		 if(binary.length() > 0) {
	    			 int val = Integer.parseInt(builder.toString(), 2);
		    		 System.out.println(val);
	    		 } else {
	    			 System.out.println(0);
	    		 }
	    	 }
	     }
	}
	
	private static String prependZero(String str, int length) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < (length - str.length()); i++) {
			builder.append('0');
		}
		
		builder.append(str);
		return builder.toString();
	}
	
	static class TrieNode {
		char val;
		HashMap<Character, TrieNode> childrens;
		
		public TrieNode(char val) {
			this.val = val;
			childrens = new HashMap<>();
		}
		
		
		public void addNumber(String binary) {
			TrieNode root = this;
			for(int i = 0; i < binary.length(); i++) {
				char c = binary.charAt(i);
				if(!root.childrens.containsKey(c)) {
					root.childrens.put(c, new TrieNode(c));
				}
				root = root.childrens.get(c);
			}
		}
		
		public void xorAll(String binary, int i) {
			
			if(i >= binary.length())
				return;
			
			TrieNode root = this;
			char c = binary.charAt(i);
			
			
			TrieNode oneNode = null;
			if(root.childrens.containsKey('1')) {
				oneNode = root.childrens.get('1');
			}
			
			TrieNode zeroNode = null;
			if(root.childrens.containsKey('0')) {
				zeroNode = root.childrens.get('0');
			}
			
			if(c == '1') {
				root.childrens.clear();
				if(oneNode != null) {
					oneNode.val = '0';
					root.childrens.put('0', oneNode);
				}
				
				if(zeroNode != null) {
					zeroNode.val = '1';
					root.childrens.put('1', zeroNode);
				}
			} 
			
			for(char ch : root.childrens.keySet()) {
				TrieNode child = root.childrens.get(ch);
				child.xorAll(binary, i + 1);
			}
		}
		
		public void getMinimum(StringBuilder builder) {
			TrieNode root = this;
			if(root.childrens.containsKey('0')) {
				builder.append('0');
				TrieNode node = root.childrens.get('0');
				node.getMinimum(builder);
			} else if(root.childrens.containsKey('1')) {
				builder.append('1');
				TrieNode node = root.childrens.get('1');
				node.getMinimum(builder);
			}
		}
	}
}
