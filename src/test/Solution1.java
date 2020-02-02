package test;

import java.util.Scanner;

public class Solution1 {
	
	
	public static void start(Integer a[][], int N, int K, boolean[] affected) {
		
		int[] result = {Integer.MAX_VALUE};
		for(int i = 0; i < N; i++) {
			int visited[] = new int[N];
			move(i, i, 0, a, visited, affected, result, true, K, N, 0);
		}
		
		System.out.println(result[0]);
	}
	
	private static void move(int base, int i, int sum, Integer a[][], int[] visited, boolean affected[], int result[], boolean isStart, int K, int N, int visitedCount) {
		
		if(base == i && visitedCount == K && !isStart) {
			if(sum < result[0]) {
				result[0] = sum;
			}
		}
		else {
			for(int k = 0; k < N; k++) {
				if(a[i][k] != null && visited[k] <= N && sum < result[0]) {
					if(affected[k] && visited[k] == 0) {
						visitedCount++;
					}
					visited[k] = visited[k] + 1;
					move(base, k, sum + a[i][k], a, visited, affected, result, false, K, N, visitedCount);
					visited[k] = visited[k] - 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] str1 = scanner.nextLine().split(" ");
		int N = Integer.parseInt(str1[0]);
		int M = Integer.parseInt(str1[1]);
		int K = Integer.parseInt(str1[2]);
		
		boolean[] affected = new boolean[N];
		String[] affectStr = scanner.nextLine().split(" ");
		for(int i= 0; i < affectStr.length; i++) {
			affected[Integer.parseInt(affectStr[i])] = true;
		}
		
		Integer a[][] = new Integer[N][N];
		
		for(int i = 0; i < M; i++) {
			String[] str2 = scanner.nextLine().split(" ");
			int u = Integer.parseInt(str2[0]);
			int v = Integer.parseInt(str2[1]);
			int w = Integer.parseInt(str2[2]);
			
			
			a[u -1][v - 1] = w;
			a[v -1][u - 1] = w;
		}
		
		scanner.close();
		
		start(a, N, K, affected);
	}
	
	/*public static void main(String[] args) {
		Integer a[][] = {
				{null, 7, null, null, null, 6},
				{7, null, 1, null, null, 5},
				{null, 1, null, 1, 3, null},
				{null, null, 1, null, 1, 4},
				{null, null, 3, 1, null, 10},
				{6, 5, null, 4, 10, null},
				};
		
		boolean affected[] = {false, false, true, true, true, false};
		start(a, 6, 3, affected);
	}*/

}
