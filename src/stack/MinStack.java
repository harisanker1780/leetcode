package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MinStack {
	
	private List<Integer> list;
	
	private int min = Integer.MAX_VALUE;

	/** initialize your data structure here. */
    public MinStack() {
    	list = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
        
        if(x < min) {
        	min = x;
        }
    }
    
    public void pop() {
    	if(list.isEmpty())
        	return;
    	int elm = list.remove(list.size() - 1);
    	if(list.isEmpty()) {
    		min = Integer.MAX_VALUE;
    	}
    	else if(elm == min) {
    		min = Integer.MAX_VALUE;
    		Iterator<Integer> itr = list.iterator();
    		while(itr.hasNext()){
    			int value = itr.next();
    			if(value < min) {
    				min = value;
    			}
    		}
    	}
    }
    
    public int top() {
        if(list.isEmpty())
        	return -1;
        
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
    	  if(list.isEmpty())
          	return -1;
    	  return min;
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	System.out.println(minStack.getMin());   
    	minStack.pop();
    	System.out.println(minStack.top());      
    	System.out.println(minStack.getMin());   
	}
}
