package hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupremeSubset {
	
	public static void main(String[] args) {
		int N = 5;
		int m = 3;
		int[] array = {3, 2, 1, 4, 5};
		printSupremeSubset(array, N, m);
	}
	
    private static void printSupremeSubset(int[] array, int N, int m) {

        Set<Integer> set = new HashSet<Integer>();
        Set<Subset> subsets = new HashSet<Subset>();

        for(int i = 0; i < N; i++) {
            set.add(array[i]);
        }

        for(int i = 0; i < N; i++) {
            if(array[i] > m) {
                int r = array[i] % m;
                if(set.contains(r)) {
                    subsets.add(new Subset(r, array[i]));
                }
            }
        }
        
        List<Subset> list = new ArrayList<Subset>(subsets);

        Collections.sort(list, new Comparator<Subset>() {
			@Override
			public int compare(Subset o1, Subset o2) {
				if(o1.i < o2.i) {
					return -1;
				} else if(o1.i > o2.i) {
					return 1;
				} else if(o1.j < o2.j) {
					return -1;
				} else if(o1.j > o2.j) {
					return 1;
				} else {
					return 0;
				}
			}
		});
        
        System.out.println(list.size());
        System.out.println(list.get(0).i + " " + list.get(0).j);
    }

    static class Subset {
        int i, j;
        public Subset(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean equals(Object other) {
            Subset o = (Subset)other;
            if(this.i != o.i) {
                return false;
            } else if(this.j != o.j) {
                return false;
            } else {
                return true;
            }
        }
    }

}
