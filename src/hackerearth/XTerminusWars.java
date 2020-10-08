package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class XTerminusWars {
	
	public static void main(String args[] ) throws Exception {
		
		System.out.println(1 << 2);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int N = Integer.parseInt(line);
        
        int wordLength = -1;
        
        TrieNode root = new TrieNode(' ');
        for(int i = 1; i <= N; i++) {
        	String word = br.readLine();
        	root.addWord(word, i);
        	
        	if(wordLength == -1) {
        		wordLength = word.length();
        	}
        }
        
        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++) {
        	String[] str = br.readLine().split(" ");
        	int L = Integer.parseInt(str[0]);
        	int R = Integer.parseInt(str[1]);
        	String targetWord = str[2];
        	
        	
        	int j = 0;
        	TrieNode start = root.getChild(targetWord.charAt(j));
        	while(start != null && hasWeightInRange(start.weights, 0, start.weights.size() - 1, L, R)) {
        		j++;
        		if(j == targetWord.length()) {
        			break;
        		}
        		
        		char c = targetWord.charAt(j);
        		start = start.getChild(c);
        	}
        	
        	int deleteCount = wordLength - j;
        	int addCount = targetWord.length() - j;
        	System.out.println(deleteCount + addCount);
        }

        
    }
	
	private static boolean hasWeightInRange(ArrayList<Integer> weight, int start , int end, int L,  int R) {
		
		if(start <= end) {
			int mid = (start + end) / 2;
			int midVal = weight.get(mid);
			
			if(midVal >= L && midVal <= R)
				return true;
			
			boolean found = false;
			if(midVal < L)
				found = hasWeightInRange(weight, mid + 1, end, L, R);
			
			if(!found && midVal > R) 
				found = hasWeightInRange(weight, start, mid - 1, L, R);
			
			return found;
		}
		
		return false;
	}
	
	static class TrieNode {
		char c;
		HashMap<Character, TrieNode> childrens;
		ArrayList<Integer> weights;
		
		public TrieNode(char c) {
			this.c = c;
			this.childrens = new HashMap<>();
			this.weights = new ArrayList<Integer>();
		}
		
		public TrieNode addChild(char c, int weight) {
			if(!childrens.containsKey(c)) {
				childrens.put(c, new TrieNode(c));
			}
			
			TrieNode child = childrens.get(c);
			child.weights.add(weight);
			return child;
		}
		
		public void addWord(String word, int weight) {
			TrieNode root = this;
			for(char c : word.toCharArray()) {
				root = root.addChild(c, weight);
			}
		}
		
		public TrieNode getChild(char c) {
			if(childrens.containsKey(c)) {
				return childrens.get(c);
			}
			
			return null;
		}
	}
}
