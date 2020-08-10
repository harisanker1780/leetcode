package test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 *
 */
public class TaskScheduler {

	 public int leastInterval(char[] tasks, int n) {
		 
		Task[] array = new Task[26];
		int count = 0;
		for(char c : tasks) {
			 if(array[c - 'A'] == null) {
				 count++;
				 array[c - 'A'] = new Task(c, 1);
			 } else {
				 array[c - 'A'].count++;
			 }
		}
		
		Task[] newArray = new Task[count];
		for(int i = 0, j = 0; i < 26; i++) {
			if(array[i] != null) {
				newArray[j++] = array[i];
			}
		}
		
		array = newArray;
		 
		sort(array);
		
		int time = 0;
		int start = 0;
		int end = count - 1;
		while(true) {
			
			int interval = n + 1;
			
			int i = start;
			//int nextStart = Integer.MAX_VALUE;
			//int nextEnd = -1;
			boolean isAllZero = true;
			while(i <= end) {
				if(array[i].count > 0) {
					array[i].count--;
					time++;
					interval--;
					
					if(array[i].count > 0) {
						isAllZero = false;
					}
				}
				
				if(interval == 0)
					break;
				
				i++;
			}
			
			if(isAllZero && i >= end)
				break;
			
			time = time + interval;
			sort(array);
		}
		
		return time;
	 }
	 
	 private void sort(Task[] array) {
		 Arrays.sort(array, new Comparator<Task>() {
				@Override
				public int compare(Task o1, Task o2) {
					if(o1.count < o2.count)
						return 1;
					else if(o1.count > o2.count)
						return -1;
					return 0;
				}
	    });
	 }
	 
	 class Task {
		 public char c;
		 public int count;
		 
		 public Task(char c, int count) {
			 this.c = c;
			 this.count = count;
		 }
	 }
	 
	 public static void main(String[] args) {
//		 TaskScheduler sol = new TaskScheduler();
//		 char[] tasks = {'A','A','A','B','B','B'};
//		 //char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
//		 //char[] tasks = {'A','A','A', 'B', 'B'};
//		 //char[] tasks = {'A','A','B','B','C','C', 'D', 'D','E','E'};
//		 //char[] tasks = {'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};
//		 System.out.println(sol.leastInterval(tasks, 2));
		System.out.println( Math.abs(-1));
	 }
}
