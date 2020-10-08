package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class NiceQueries {

    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");                // Reading input from STDIN
        int N = Integer.parseInt(line[0]);
        int Q = Integer.parseInt(line[1]);

        Query query = new Query(N);
        for(int i = 0; i < Q; i++) {
            String[] str = br.readLine().split(" ");
            int type = Integer.parseInt(str[0]);
            if(type == 1) {
                query.set(Integer.parseInt(str[1]));
            } else if(type == 2) {
                System.out.println(query.get(Integer.parseInt(str[1])));
            }
        }
    }

    static class Query  {
        int N;
        TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map;

        public Query(int N) {
            this.N = N;
            map =  new TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>>();

            int i = 1;
            while(i < N) {
                i = i * 10;
            }
            this.N = i;
        }

        public void set(int index) {
            int[] keys = getKeys(index);
            int pKey = keys[0];
            int sKey = keys[1];

            if(!map.containsKey(pKey)) {
                map.put(pKey, new TreeMap<Integer, TreeSet<Integer>>());
            }

            TreeMap<Integer, TreeSet<Integer>> subMap = map.get(pKey);
            if(!subMap.containsKey(sKey)) {
                subMap.put(sKey, new TreeSet<Integer>());
            }

            TreeSet<Integer> set = subMap.get(sKey);
            set.add(index);
        }

        public int get(int index) {
            int[] keys = getKeys(index);
            int pKey = keys[0];
            int sKey = keys[1];

            if(map.containsKey(pKey)) {
                TreeMap<Integer, TreeSet<Integer>> subMap = map.get(pKey);
                if(subMap.containsKey(sKey)) {
                    TreeSet<Integer> set = subMap.get(sKey);
                    if(!set.isEmpty()) {
                        if(set.contains(index)) {
                            return index;
                        }

                        if(set.last() > index) {
                            return set.higher(index);
                        }
                    }
                }
            }

            if(map.containsKey(pKey)) {
                TreeMap<Integer, TreeSet<Integer>> subMap = map.get(pKey);
                if(!subMap.isEmpty()) {
                	Integer fromKey = sKey + 1;
                	Integer toKey = subMap.lastKey();
                	if(fromKey <= toKey) {
                		NavigableMap<Integer, TreeSet<Integer>> tempSubMap = subMap.subMap(fromKey, true, toKey, true);
                        for(Integer i : tempSubMap.keySet()) {
                            TreeSet<Integer> set = subMap.get(i);
                            if(!set.isEmpty()) {
                                return set.first();
                            }
                        }
                	}
                }
            }
            
            if(!map.isEmpty()) {
            	Integer fromKey = pKey + 1;
            	Integer toKey = map.lastKey();
            	if(fromKey <= toKey) {
            		NavigableMap<Integer, TreeMap<Integer, TreeSet<Integer>>> temp = map.subMap(fromKey, true, toKey, true);
                    for(Integer i : temp.keySet()) {
                        TreeMap<Integer, TreeSet<Integer>> subMap = map.get(i);
                        for(Integer j : subMap.keySet()) {
                            TreeSet<Integer> set = subMap.get(j);
                            if(!set.isEmpty()) {
                                return set.first();
                            }
                        }
                    }
            	}
            }

            return -1;
        }

        public int[] getKeys(int index) {
            int div = Math.max(N / 10, 1);
            int subDiv = Math.max(div / 10, 1);
            int[] keys = new int[2];
            int pKey = index / div;
            int r = index % div;
            int sKey = r / subDiv;
            keys[0] = pKey;
            keys[1] = sKey;
            return keys;
        }
    }

}
