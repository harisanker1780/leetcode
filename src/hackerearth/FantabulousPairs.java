package hackerearth;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class FantabulousPairs {
	
	public static void main(String[] args) {
		int[] array = {1, 3, 2, 4};
		int N = 4;
		//printCount(array, N);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.removeFirst();
		list.add(2);
		System.out.print(list.getFirst());
		
	}
	
    private static void printCount(int[] array, int N) {
        Set<Pair> set = new HashSet<Pair>();
        for(int start = 0; start < N - 1; start++) {
            int end = start + 1;
            int hIndex = start;
            int shIndex = start;
            while(end < N) {
                int val = array[end];
                int hVal = array[hIndex];
                int shVal = array[shIndex];

                if(val > hVal) {
                	shIndex = hIndex;
                    hIndex = end;
                } else if(val > shVal) {
                    shIndex = end;
                }

                if(shIndex < hIndex) {
                    set.add(new Pair(shIndex - start, hIndex - start));
                }

                end++;
            }
        }
     
        System.out.println(set.size());
    }

    static class Pair {
        public int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}
        
    }

}
