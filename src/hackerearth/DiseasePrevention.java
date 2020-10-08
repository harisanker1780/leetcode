package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class DiseasePrevention {
	
	private static int count = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] line = br.readLine().split(" ");
	    int N = Integer.parseInt(line[0]);
	    int M = Integer.parseInt(line[1]);
	    String[] str = br.readLine().split(" ");
	    
	    boolean[] infected = new boolean[N];
	    for(int i = 0; i < M; i++) {
	    	int val = Integer.parseInt(str[i]);
	    	infected[val - 1] = true;
	    }
	   
	    ArrayList<Integer> unInfected = new ArrayList<>();
	    for(int i = 0; i < N; i++) {
	    	if(!infected[i]) {
	    		unInfected.add(i);
	    	}
	    }
		
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		

		for(int i = 0; i < N; i++) {
			if(infected[i] != true) {
				permutations(unInfected, set, i, infected);
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void permutations(ArrayList<Integer> unInfected, LinkedHashSet<Integer> set, int nextVal, boolean[] infected) {
		set.add(nextVal);
		infected[nextVal] = true;
		if(set.size() == unInfected.size()) {
			count++;
		} else {
			for(int i = 0; i < unInfected.size(); i++) {
				int index = unInfected.get(i);
				if(!set.contains(index)) {
					boolean isNeighbourInfected = false;
					if(index > 0) {
						isNeighbourInfected = infected[index - 1];
					}
					
					if(index < infected.length - 1) {
						isNeighbourInfected |= infected[index + 1];
					}
					
					if(isNeighbourInfected) {
						permutations(unInfected, set, index, infected);
					}
				}
			}
		}
		
		infected[nextVal] = false;
		set.remove(nextVal);
	}

}
