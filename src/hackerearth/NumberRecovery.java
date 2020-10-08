package hackerearth;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class NumberRecovery {
	   public static void main(String args[] ) throws Exception {
	       
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String[] line = br.readLine().split(" ");                // Reading input from STDIN
	        int N = Integer.parseInt(line[0]);
	        int Q = Integer.parseInt(line[1]);

	        int[][] hints = new int[N][2];
	        for(int i = 0; i < N; i++) {
	            String[] str = br.readLine().split(" ");
	            hints[i][0] = Integer.parseInt(str[0]);
	            hints[i][1] = Integer.parseInt(str[1]);
	        }

	        Number number = new Number(hints, N);

	        for(int i = 0; i < Q; i++) {
	            String[] str = br.readLine().split(" ");
	            int type = Integer.parseInt(str[0]);
	            int index = Integer.parseInt(str[1]);

	            int[] result = number.execute(type, index);
	            
	            for(int r : result) {
	                System.out.print(r + " ");
	            }

	            System.out.println();
	        }
	    }

	    static class Number {

	        int[][] hints;
	        int[] types;

	        HashMap<Integer, Integer> values;
	        HashMap<Integer, Integer> notValues;

	        public Number(int[][] hints, int N) {
	            this.hints = hints;
	            this.values = new HashMap<Integer, Integer>();
	            this.notValues = new HashMap<Integer, Integer>();
	            this.types = new int[N];

	            for(int i = 0; i < N; i++) {
	                types[i] = 3;
	            }
	        }

	        public int[] execute(int targetType, int index) {
	            index = index - 1;
	            int curType = types[index];

	            if(curType != targetType) {
	                if(curType == 1 && targetType == 3) {
	                    remove(values, index);
	                } 
	                else if(curType == 2 && targetType == 3) {
	                    remove(notValues, index);
	                }
	                else if(curType == 1 && targetType == 2) {
	                    remove(values, index);
	                    add(notValues, index);
	                }
	                else if(curType == 2 && targetType == 1) {
	                    remove(notValues, index);
	                    add(values, index);
	                }
	                else if(curType == 3 && targetType == 1) {
	                    add(values, index);
	                }
	                else if(curType == 3 && targetType == 2) {
	                    add(notValues, index);
	                }
	                
	                types[index] = targetType;
	            }

	            if(!values.isEmpty() && notValues.isEmpty()) {
	                if(values.size() > 2) {
	                    int[] result = {0};
	                    return result;
	                } else if(values.size() == 2) {
	                    int[] result = {2, 0, 0};
	                    Iterator<Integer> itr = values.keySet().iterator();
	                    result[1] = itr.next();
	                    result[2] = itr.next();
	                    return result;

	                } else {
	                    int[] result = {1, 0};
	                    result[1] = values.keySet().iterator().next();
	                    return result;
	                } 
	            } else if(values.isEmpty() && notValues.isEmpty()) {
	                int[] result = {-1};
	                return result;
	            } else if(values.isEmpty() && !notValues.isEmpty()) {
	                int[] result = {-1};
	                return result;
	            } else {
	                for(Integer val : values.keySet()) {
	                    if(notValues.containsKey(val)) {
	                        int[] result = {0};
	                        return result;
	                    }
	                }

	                if(values.size() > 2) {
	                    int[] result = {0};
	                    return result;
	                } else if(values.size() == 2) {
	                    int[] result = {2, 0, 0};
	                    Iterator<Integer> itr = values.keySet().iterator();
	                    result[1] = itr.next();
	                    result[2] = itr.next();
	                    return result;

	                } else {
	                    int[] result = {1, 0};
	                    result[1] = values.keySet().iterator().next();
	                    return result;
	                }
	            }
	        }

	        private void remove(HashMap<Integer, Integer> map, int index)  {
	            int a = this.hints[index][0];
	            int d = this.hints[index][1];
	            Set<Integer> values = getValues(a, d);
	            for(Integer val : values) {
	                if(map.containsKey(val)) {
	                    map.put(val, map.get(val) - 1);
	                    if(map.get(val) == 0) {
	                        map.remove(val);
	                    }
	                }
	            }
	        }

	        private void add(HashMap<Integer, Integer> map, int index) {
	            int a = this.hints[index][0];
	            int d = this.hints[index][1];
	            Set<Integer> values = getValues(a, d);
	            for(Integer val : values) {
	                if(!map.containsKey(val)) {
	                    map.put(val, 0);
	                }

	                map.put(val, map.get(val) + 1);
	            }
	        }

	        private Set<Integer> getValues(int a, int d) {
	            Set<Integer> result = new HashSet<Integer>();
	            result.add(a + d);

	            if(a - d >= 0) {
	                result.add(a - d);
	            }

	            return result;
	        }
	    }

}
