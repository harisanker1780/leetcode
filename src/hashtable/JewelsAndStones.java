package hashtable;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
	
	public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() == 0 || S == null || S.length() == 0) {
        	return 0;
        }
        
        Set<Character> set = new HashSet<Character>();
        char[] jewels = J.toCharArray();
        for(char c : jewels) {
        	set.add(c);
        }
        
        char[] stones = S.toCharArray();
        int jewelsCount = 0;
        for(char c : stones) {
        	if(set.contains(c)) {
        		jewelsCount++;
        	}
        }
        
        return jewelsCount;
    }
	
	public static void main(String[] args) {
		JewelsAndStones sol = new JewelsAndStones();
		System.out.println(sol.numJewelsInStones("z", "ZZ"));
	}
}
