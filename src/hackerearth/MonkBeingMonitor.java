package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Monk being the monitor of the class needs to have all the information about the class students. He is very busy with many tasks related to the same, so he asked his friend Mishki for her help in one task. She will be given heights of all the students present in the class and she needs to choose 2 students having heights  and  respectively, such that  and difference between the number of students having height  and number of students having height  is maximum.

Note: The difference should be greater than 0.

As Mishki has never been a monitor of the class, help her in the same. If there exists such students, then print the required difference else print "1" (without quotes).

Input:
The first line will consists of one integer T, which denotes the number of test cases.
For each test case:
One line consists of a integer N, denotes the number of students in the class.
Second line contains N space separated integers, where  integer denotes the height of the  student in the class.
Output:

For each test case, if the required difference exists then print its value, otherwise print 1. Print the answer for each test case in a new line.
Constraints:



Sample Input
1
6
3 1 3 2 3 2
Sample Output
2
Explanation
Here T=1 and N = 6.

Number of students having height = 3 is 3.
Number of students having height = 2 is 2.
Number of students having height = 1 is 1.

Here Mishki can choose students with height=3 () and height = 1 () , as the difference between number of students having height () and number of students having height () is maximum and greater than 0.
 *
 */
public class MonkBeingMonitor {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
        	Integer N = Integer.parseInt(br.readLine());
        	Integer[] array = new Integer[N];
        	String[] line = br.readLine().split(" ");
        	for(int i = 0; i < N; i++) {
        		array[i] = Integer.parseInt(line[i]);
        	}
        	
        	System.out.println(diff(array));
        }
	}
	
	private static int diff(Integer[] array) {
		
		Arrays.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2) {
					return 1;
				} else if(o1 > o2) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		Integer max = Integer.MIN_VALUE;
		Integer diff = 0;
		int i = 0;
		int N = array.length;
		while(i < N) {
			int count = 0;
			int prev = array[i];
			
			while(i < N && array[i] == prev) {
				count++;
				prev = array[i];
				i++;
			}
			
			if(count < max) {
				diff = Math.max(diff, max - count);
			} else {
				max = count;
			}
		}
		
		return diff == null || diff <= 0 ? -1 : diff;
	}
	
	static class Test implements Comparable<Test> {

		@Override
		public int compareTo(Test o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
