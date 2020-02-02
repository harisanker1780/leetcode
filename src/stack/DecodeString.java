package stack;

import java.util.Stack;

public class DecodeString {

	public String decodeString(String s) {
		char[] input = s.toCharArray();
		int start = 0;
		int end = input.length - 1;
		StringBuilder output = new StringBuilder();
		int repeat = 1;
		
		decodeString(input, start, end, output, repeat);
		return output.toString();
    }
	
	private void decodeString(char[] input, int start, int end, StringBuilder output, int repeat) {
		for(int r = 0; r < repeat; r++) {
			for(int i = start; i <= end; i++) {
				char c = input[i];
				if(Character.isDigit(c)) {
					String num = "";
					while(Character.isDigit(c)) {
						num = num + c;
						c = input[++i];
					}
					i++; // skip [
					
					int newStart = i;
					int newRepeat = Integer.parseInt(num);
					
					Stack<Character> stack = new Stack<Character>();
					c = input[i];
					while(c != ']' || !stack.isEmpty()) {
						if(c == '[') {
							stack.push(c);
						}
						else if(c == ']') {
							stack.pop();
						}
						c = input[++i]; 
					}
					int newEnd = i - 1;
					
					StringBuilder newOutput = new StringBuilder();
					decodeString(input, newStart, newEnd, newOutput, newRepeat);
					output.append(newOutput);
				}
				else if(c != '[' && c != ']') {
					output.append(c);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DecodeString solution = new DecodeString();
		//String input = "3[a]2[bc]";
		//String input = "3[a2[c]]";
		String input = "2[abc]3[cd]ef";
		//String input = "3[a]2[b4[F]c]";
		
		System.out.println(solution.decodeString(input));
	}
}
