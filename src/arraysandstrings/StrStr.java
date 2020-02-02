package arraysandstrings;

public class StrStr {
	
	 public int strStr(String haystack, String needle) {
		 
		 if(needle == null || needle.equals(""))
			 return 0;
		 
		 
		 if(haystack == null || haystack.equals(""))
			 return -1;
		
		 
		 if(needle.length() > haystack.length())
			 return -1;
		 
		 int i = 0;
		 while(i < haystack.length()) {
			 int k = i;
			 int j = 0;
			 while(j < needle.length() && k < haystack.length()) {
				 if(haystack.charAt(k) != needle.charAt(j)) {
					 break;
				 }
				 k++;
				 j++;
			 }
			 
			 if(j == needle.length()){
				 return i;
			 }
			 
			 i++;
		 }
		 
		 return -1;
	 }
	 
	public static void main(String[] args) {
		StrStr sol = new StrStr();
		//String haystack = "hello", needle = "ll";
		String haystack = "aaaaa", needle = "bba";
		System.out.println(sol.strStr(haystack, needle));
	}
}
