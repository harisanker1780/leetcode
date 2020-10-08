package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * Monk and Rotation
Monk loves to preform different operations on arrays, and so being the principal of Hackerearth School, he assigned a task to his new student Mishki. Mishki will be provided with an integer array A of size N and an integer K , where she needs to rotate the array in the right direction by K steps and then print the resultant array. As she is new to the school, please help her to complete the task.

Input:
The first line will consists of one integer T denoting the number of test cases.
For each test case:
1) The first line consists of two integers N and K, N being the number of elements in the array and K denotes the number of steps of rotation.
2) The next line consists of N space separated integers , denoting the elements of the array A.
Output:
Print the required array.

Constraints:




Sample Input
1
5 2
1 2 3 4 5
Sample Output
4 5 1 2 3
 *
 */
public class MonkAndRotation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
        	String[] line  = br.readLine().split(" ");
        	Integer N = Integer.parseInt(line[0]);
        	Integer K = Integer.parseInt(line[1]);
        	
        	Integer[] array = new Integer[N];
        	line = br.readLine().split(" ");
        	for(int i = 0; i < N; i++) {
        		array[i] = Integer.parseInt(line[i]);
        	}
        	
        	K =  K % N;
        	int index =  (N - K);
        	for(int i = 0; i < N; i++) {
        		index = index % N;
        		System.out.print(array[index] + " ");
        		index++;
        	}
        	
        	System.out.println();
        }

       
	}
}
