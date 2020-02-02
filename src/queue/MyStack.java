package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	
	private Queue<Integer> q1;
	private Queue<Integer> q2;

	/** Initialize your data structure here. */
    public MyStack() {
    	q1 = new LinkedList<Integer>();
    	q2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	copyToQueue2();
        int elem = -1;
        if(!q2.isEmpty()) {
        	elem = q2.remove();
        }
        return elem;
    }
    
    /** Get the top element. */
    public int top() {
    	copyToQueue2();
    	int elem = -1;
        if(!q2.isEmpty()) {
        	elem = q2.peek();
        }
        return elem;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    
    private void copyToQueue2() {
    	int array[] = new int[q1.size() + q2.size()];
    	int i = q1.size() - 1;
    	while(!q1.isEmpty()) {
    		array[i] = q1.remove();
    		i--;
    	}
    	
    	i  = array.length - q2.size();
    	while(!q2.isEmpty()) {
    		array[i] = q2.remove();
    		i++;
    	}
    
    	i = 0;
    	while(i < array.length) {
    		q2.add(array[i]);
    		i++;
    	}
    }
    
    public static void main(String[] args) {
    	 MyStack obj = new MyStack();
    	 obj.push(1);
    	 obj.push(2);
    	 System.out.println(obj.top());
    	 obj.push(3);
    	 System.out.println(obj.top());
    	 System.out.println(obj.empty());
	}
}
