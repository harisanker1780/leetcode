package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	
	public int evalRPN(String[] tokens) {
		
        if(tokens == null || tokens.length == 0)
        	return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String token: tokens) {
        	if(token.equals("+")) {
        		int x = stack.pop();
        		int y = stack.pop();
        		stack.push(y + x);
        	}
        	else if(token.equals("-")) {
        		int x = stack.pop();
        		int y = stack.pop();
        		stack.push(y - x);
        	}
        	else if(token.equals("*")) {
        		int x = stack.pop();
        		int y = stack.pop();
        		stack.push(y * x);
        	}
        	else if(token.equals("/")) {
        		int x = stack.pop();
        		int y = stack.pop();
        		stack.push(y / x);
        	}
        	else {
        		stack.push(Integer.parseInt(token.trim()));
        	}
        }
        
        return stack.pop();
    }
	
	public static void main(String[] args) {
		//String input[] = {"2", "1", "+", "3", "*"};
		String input[] = {"4", "13", "5", "/", "+"};
		//String input[] = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		
		EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
		System.out.println(solution.evalRPN(input));
	}
}
