package arraysandstrings;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
       if(strs == null || strs.length == 0)
    	   return "";
       
       int index = 0;
       StringBuilder result = new StringBuilder();
       while(true) {
    	  boolean hasMatchingPrefix = true;
    	  Character prefix = null;
    	  for(int i = 0; i < strs.length; i++) {
    		  if(index >= strs[i].length()) {
    			  hasMatchingPrefix = false;
    			  break;
    		  }
    		  else if(prefix == null) {
        		  prefix = strs[i].charAt(index); 
        	  }
    		  else if(!prefix.equals(strs[i].charAt(index))) {
				  hasMatchingPrefix = false;
    			  break;
			  }
          }   
    	  
    	  index++;
    	  
    	  if(hasMatchingPrefix) {
    		  result.append(prefix);
    	  }
    	  else {
    		  break;
    	  }
       }
       
       return result.toString();
    }
	
	public static void main(String[] args) {
		//String[] input = {"flower","flow","flight"};
		String[] input = {"dog","racecar","car"};
		LongestCommonPrefix sol = new LongestCommonPrefix();
		System.out.println(sol.longestCommonPrefix(input));
	}
}
