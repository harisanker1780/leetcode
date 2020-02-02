package queue;

public class MyCircularQueue {
	
	private int array[];
	private int head = -1, tail = -1, size = 0;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
    	size = k;
    	array = new int[size];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if(isFull()) {
    		return false;
    	}
    	
    	if(isEmpty()) {
    		head = 0;
    	}
    	
    	tail = (tail + 1) % size;
    	array[tail] = value;
    	return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
        	return false;
        }
        
        if(head == tail) {
        	head = -1;
        	tail = -1;
        	return true;
        }
        
        head = (head + 1) % size;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(isEmpty()) {
    		return -1;
    	}
        
    	return array[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty()) {
    		return -1;
    	}
        
    	return array[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    	return ((tail + 1) % size) == head;
    }
    
    
    public static void main(String[] args) {
    	MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
    	System.out.println(circularQueue.enQueue(1));  // return true
    	System.out.println(circularQueue.enQueue(2));  // return true
    	System.out.println(circularQueue.enQueue(3));  // return true
    	System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
    	System.out.println(circularQueue.Rear());  // return 3
    	System.out.println(circularQueue.isFull());  // return true
    	System.out.println(circularQueue.deQueue());  // return true
    	System.out.println(circularQueue.enQueue(4));  // return true
    	System.out.println(circularQueue.Rear());  // return 4
	
    	/*MyCircularQueue circularQueue = new MyCircularQueue(3);
    	System.out.println(circularQueue.enQueue(1));
    	System.out.println(circularQueue.Rear());
    	System.out.println(circularQueue.Rear());*/
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */