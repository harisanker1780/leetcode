package test;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 *
 */
public class EvaluateReversePolishNotation {
	
	 public int evalRPN(String[] tokens) {
	 
		 Stack<Integer> stack = new Stack<Integer>();
		 for(String token : tokens) {
			 if(isOperator(token)) {
				 Integer op1 = stack.pop();
				 Integer op2 = stack.pop();
				 Integer result = null;
				 
				 switch(token) {
				 	case "+":
				 		result = op2 + op1;
				 	break;
				 	case "-":
				 		result = op2 - op1;
				 	break;
				 	case "*":
				 		result = op2 * op1;
				 	break;
				 	case "/":
				 		result = op2 / op1;
				 	break;
				 }
				 
				 if(result != null) {
					 stack.push(result);
				 }
			 } else {
				 stack.push(Integer.parseInt(token));
			 }
		 }
		 
		 return stack.pop();
	 }
	 
	 private boolean isOperator(String token) {
		 token = token.trim();
		 return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	 }
	 
	 public static void main(String[] args) {
		 EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();
		 String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		 System.out.println(sol.evalRPN(tokens));
	 }
}
