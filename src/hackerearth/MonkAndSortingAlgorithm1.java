package hackerearth;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MonkAndSortingAlgorithm1 {
	
	public static void main(String[] args) throws Exception {
		String[] array = {"213456789", "167890", "123456789", "99", "11"};
		sort(array);
	}
	
	private static void sort(String[] array) throws Exception {
		
		OutputStream out = new BufferedOutputStream ( System.out );
		
		int start = 0;
		int N = array.length;
		int itrCount = 0;
		int[] indexArray = new int[N];
		for(int i = 0; i < N; i++) {
			indexArray[i] = i;
		}
		
		while(true) {
			
			while(start < N) {
				int index = array[indexArray[start]].length() - (5 * itrCount); 
				if(index > 0) {
					break;
				}
				start++;
			}
			
			if(start >= N)
				break;
			
			ArrayList<Integer>[] indexSorted = new ArrayList[100000];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i = start; i < N; i++) {
				String s = array[indexArray[i]];
				int num = getNumber(s, (s.length() - (5 * itrCount)) - 1);
				
				if(num < min) {
					min = num;
				}
				
				if(num > max) {
					max = num;
				}
				
				if(indexSorted[num] == null) {
					indexSorted[num] = new ArrayList<Integer>();
				}
				
				indexSorted[num].add(indexArray[i]);
			}
			
			int j = start;
			for(int i = min; i <= max; i++) {
				ArrayList<Integer> list = indexSorted[i];
				if(list != null) {
					for(int l : list) {
						indexArray[j++] = l;
					}
				}
			}
			
			for(int i : indexArray) {
				String s = array[i];
				out.write((s + " ").getBytes());
			}
			
			out.write("\n".getBytes());
			itrCount++;
		}
		
		out.flush();
	}
	
	private static int getNumber(String s, int end) {
		int val = 0;
		if(end >= 0) {
			int base = 1;
			while(base <= 10000 && end >= 0) {
				val += base * (int)(s.charAt(end) - '0');
				base = base * 10;
				end--;
			}
		}
		
		return val;
	}

}
