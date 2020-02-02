package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution2 {
	
	public static void start(Map<Integer, SortedSet<Path>> map, int N, int K, boolean affected[])  {
		int[] result = {Integer.MAX_VALUE};
		for(int i = 0; i < N; i++) {
			if(!affected[i]) {
				move(map, i, i, 0, K, 0, result, affected, true);
			}
		}
		
		System.out.println(result[0]);
		
	}
	
	public static void move(Map<Integer, SortedSet<Path>> map, int start, int i, int sum, int K, int visitedCount, int result[], boolean affected[], boolean isStart) {
		if(!isStart && start == i && visitedCount == K) {
			if(sum < result[0]) {
				result[0] = sum;
			}
		}
		
		SortedSet<Path> set = map.get(i);
		if(set != null) {
			for(Path p : set) {
				if(!p.visited && sum < result[0]) {
					
					if(!affected[p.u]) {
						visitedCount++;
					}
					
					p.visited = true;
					move(map, start, p.v,  sum + p.value, K, visitedCount, result, affected, false);
					p.visited = false;
				}
			}
		}
	}
	
	/*public static void main(String[] args) {
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
		
		//Integer a[][] = new Integer[N][N];
		Map<Integer, SortedSet<Path>> map = new HashMap<Integer, SortedSet<Path>>();
		
		for(int i = 0; i < M; i++) {
			String[] str2 = scanner.nextLine().split(" ");
			int u = Integer.parseInt(str2[0]);
			int v = Integer.parseInt(str2[1]);
			int w = Integer.parseInt(str2[2]);
			
			SortedSet<Path> set1 = map.get(u - 1);
			if(set1 == null) {
				set1 = new TreeSet<Path>();
				map.put(u - 1, set1);
			}
			set1.add(new Path(u - 1, v - 1, w));
			
			SortedSet<Path> set2 = map.get(v - 1);
			if(set2 == null) {
				set2 = new TreeSet<Path>();
				map.put(v - 1, set2);
			}
			set2.add(new Path(v - 1, u - 1, w));
			
			
//			a[u -1][v - 1] = w;
//			a[v -1][u - 1] = w;
		}
		
		scanner.close();
		
		start(map, N, K, affected);
	}*/
	
	
	public static void main(String[] args) {
		Map<Integer, SortedSet<Path>> map = new HashMap<Integer, SortedSet<Path>>();
		map.put(0, new TreeSet<Path>());
		map.put(1, new TreeSet<Path>());
		map.put(2, new TreeSet<Path>());
		
		map.get(0).add(new Path(0, 1, 1));
		map.get(0).add(new Path(0, 2, 3));
		map.get(1).add(new Path(1, 2, 2));
		map.get(1).add(new Path(1, 0, 1));
		map.get(2).add(new Path(2, 1, 2));
		map.get(2).add(new Path(2, 0, 3));
		
		boolean affected[] = {false, false, true};
		start(map, 3, 1, affected);
		
		
//		SortedSet<Path> test = new TreeSet<Path>();
//		test.add(new Path(0, 2, 3));
//		test.add(new Path(0, 2, 1));
//		for(Path p : test) {
//			System.out.println(p.value);
//		}
	}

}
class Path implements Comparable<Path>  {
	public int value, u, v;
	public boolean visited;
	
	public Path(int u, int v, int value) {
		this.u = u;
		this.v = v;
		this.value = value;
	}

	@Override
	public int compareTo(Path other) {
		return this.value - other.value;
	}
}
