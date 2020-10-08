package test;

public class RegularExpressionMatching {

	 public boolean isMatch(String s, String p) {
		 return isMatch(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1);
	 }
	 
	 public boolean isMatch(char[] s, char[] p, int i, int j) {
		 
		 if(j <= 0)
			 return false;
		 
		 if(i == 0) {
			 while(j >= 0 && p[j] == '*') {
				 j = j - 2;
			 }
			 
			 if(j == 0 && (s[i] == p[j] || p[j] == '.')) {
				 return true;
			 } else {
				 return false;
			 }
		 }
		 
		 if(s[i] == p[j])
			 return isMatch(s, p, i - 1, j - 1);
		 
		 if(p[j] == '.')
			 return isMatch(s, p, i - 1, j - 1);
		 
		 if(p[j] == '*') {
			 if(s[i] == p[j - 1] || p[j - 1] == '.') {
				 return isMatch(s, p, i - 1, j) // More than one
						 || isMatch(s, p, i, j - 2) // Zero
				 		 || isMatch(s, p, i, j - 1); // One
			 } else {
				 return isMatch(s, p, i, j - 2);
			 }
		 }
		 
		 return false;
	 }
	 
	 public static void main(String[] args) {
		 RegularExpressionMatching sol =  new RegularExpressionMatching();
		 //System.out.println(sol.isMatch("aa", "a"));
		 System.out.println(sol.isMatch("aa", "a*"));
		 //System.out.println(sol.isMatch("ab", ".*"));
		 //System.out.println(sol.isMatch("aab", "c*a*b"));
		 //System.out.println(sol.isMatch("aabbcc", "aaa*b*.*"));
		 //System.out.println(sol.isMatch("aaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbcdddd", "aaa*b*c*dddddddd*"));
		 //System.out.println(sol.isMatch("ab", "b*a*"));
	 }
}
