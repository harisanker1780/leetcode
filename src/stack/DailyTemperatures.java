package stack;

import java.util.Stack;

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] T) {
		
		if(T == null)
			return null;
		
		int[] result = new int[T.length];
		
		Stack<Item> stack = new Stack<Item>();
		for(int i = T.length - 1; i >= 0; i--) {
			int w = 0;
			
			while(!stack.isEmpty()) {
				Item top = stack.peek();
				if(top.value > T[i]) {
					w = top.index - i;
					stack.push(new Item(T[i], i));
					break;
				}
				else {
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) {
				w = 0;
				stack.push(new Item(T[i], i));
			}
			
			result[i] = w;
		}
		
		return result;
    }
	
	class Item {
		int value, index;
		public Item(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
	
	public static void main(String[] args) {
		DailyTemperatures dt = new DailyTemperatures();
		int input[] = {89,62,70,58,47,47,46,76,100,70};
		int result[] = dt.dailyTemperatures(input);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}
}
