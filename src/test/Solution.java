package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	
	public static void race(int N, Map<Integer, List<Node>> map) {
		
		int result[] = {Integer.MAX_VALUE, 0};
		for(int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			move(map, i, i, 0, 0, N, visited, result, true);
		}
		System.out.println(result[0] + " " + result[1]);
	}
	
	private static void move(Map<Integer, List<Node>> map, int start, int i, int sum, int move, int N, boolean[] visited, int[] result, boolean isStart) {
		if(start == i && !isStart) {
			if(move < result[0] && sum > 0) {
				result[0] = move;
				result[1] = sum;
			}
			
			else if(move == result[0] && sum > result[1]) {
				result[1] = sum;
			}
		}
		else {
			/*
			 * for(int k = 0; k < N; k++) { if(a[i][k] != null && !visited[k] && (move <
			 * result[0] || (move == result[0] && sum > result[1]))) { visited[k] = true;
			 * move(a, start, k, sum + a[i][k], move + 1, N, visited, result, false);
			 * visited[k] = false; } }
			 */
			
			List<Node> list = map.get(i);
			if(list != null) {
				for(Node n : list) {
					if(!visited[n.index] && (move < result[0] || (move == result[0] && sum > result[1]))) {
						visited[n.index] = true;
						move(map, start, n.index,  sum + n.value, move + 1, N, visited, result, false);
						visited[n.index] = false;
					}
				}
			}
		}
	}
	
	public static class Node {
		public int index;
		public int value;
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] str1 = scanner.nextLine().split(" ");
		int N = Integer.parseInt(str1[0]);
		int M = Integer.parseInt(str1[1]);
		
		//Integer a[][] = new Integer[N][N];
		
		Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		
		for(int i = 0; i < M; i++) {
			String[] str2 = scanner.nextLine().split(" ");
			int u = Integer.parseInt(str2[0]);
			int v = Integer.parseInt(str2[1]);
			int t = Integer.parseInt(str2[2]);
			int h = Integer.parseInt(str2[3]);
			
			List<Node> list = map.get(u - 1);
			if(list == null) {
				list = new LinkedList<Node>();
				map.put(u - 1, list);
			}
			list.add(new Node(v - 1, h - t));
			//a[u -1][v - 1] = h - t;
		}
		
		scanner.close();
		
		race(N, map);
	}
	
	/*public static void main(String[] args) {
		Integer a[][] = {
				{null, 8, null, null},
				{null, null, 396, null},
				{999, null, null, 92},
				{null, null, 3, null},
		};
		
		Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		map.put(0, new ArrayList<Node>());
		map.put(1, new ArrayList<Node>());
		map.put(2, new ArrayList<Node>());
		map.put(3, new ArrayList<Node>());
		
		map.get(0).add(new Node(1, 8));
		map.get(1).add(new Node(2, 396));
		map.get(1).add(new Node(3, 57));
		map.get(2).add(new Node(0, 999));
		map.get(2).add(new Node(3, 92));
		map.get(3).add(new Node(2, 3));
		map.get(3).add(new Node(1, 67));
		
		race(4, map);
	}*/

}
