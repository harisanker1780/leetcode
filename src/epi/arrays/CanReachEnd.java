package epi.arrays;

import java.util.List;

public class CanReachEnd {
	
	public static boolean canReachEnd(List<Integer> list) {
		int furthestReachedSoFar = 0, lastIndex = list.size() - 1;
		for(int i = 0; i <= furthestReachedSoFar && furthestReachedSoFar < lastIndex; i++) {
			furthestReachedSoFar = Math.max(furthestReachedSoFar, i + list.get(i));
		}
		
		return furthestReachedSoFar >= lastIndex;
	}

}
