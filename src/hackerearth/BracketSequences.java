package hackerearth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class BracketSequences {
	
	  public static void main(String[] args) {
		
	  }
	
	  private static int getCount(char[] array) {

	        int result = 0;

	        for(int j = 0; j < array.length; j++) {

	            int start = j;
	            while(start < array.length && array[start] != '(')
	                start++;
	            
	            if(start == array.length)
	            	continue;

	            Stack<Character> stack = new Stack<Character>();
	            stack.push(array[start]);
	            start = (start + 1) % array.length;

	            int count = 0;
	            int i = 1;
	            for(; i < array.length; i++) {
	                if(array[start] == '(') {
	                    stack.push('(');
	                } else {
	                    if(!stack.isEmpty()) {
	                        stack.pop();
	                        if(stack.isEmpty())
	                            count++;
	                    } else {
	                        break;
	                    }
	                }

	                start = (start + 1) % array.length;
	            }

	            if(i == array.length) {
	                result = count;
	                break;
	            }
	        }
	        
	        return result;
	  }

}
