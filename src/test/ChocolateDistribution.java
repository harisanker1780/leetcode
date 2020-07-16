package test;

import java.util.Arrays;

public class ChocolateDistribution {
	
	public static int[] distributeChocolate(int n, int k) {
		int dist[] = new int[k];
		int c = 1;
		int i = 0;
		while(n > 0) {
			int index = i++ % k;
			dist[index] = dist[index] + Math.min(n, c);
			n = n - c;
			c++;
		}
		
		return dist;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(distributeChocolate(7, 4)));
	}

}
