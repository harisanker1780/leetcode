package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class HolidaySeason {
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int N = Integer.parseInt(line);
        String str = br.readLine();
        HashMap<Character, ArrayList<Integer>> freq = buildFreqMap(str, N);
        System.out.println(getCount(freq));
    }

    private static long getCount(HashMap<Character, ArrayList<Integer>> freq) {
        long count = 0;
        for(char key : freq.keySet()) {
            for(char otherKey : freq.keySet()) {
                if(key != otherKey) {
                    ArrayList<Integer> X = freq.get(key);
                    ArrayList<Integer> Y = freq.get(otherKey);

                    if(!(X.size() > 1 && Y.size() > 1))
                        continue;

                    if(X.get(0) >= Y.get(Y.size() - 1))
                        continue;

                   
                    for(int a = 0; a < X.size() - 1; a++) {
                        for(int c = a + 1; c < X.size(); c++) {
                        	int b = 0;
                            int d = 0;

                            while( b < Y.size() - 1 && X.get(a) > Y.get(b))
                                b++;
                            while( d < Y.size() && X.get(c) > Y.get(d))
                                d++;
                            
                            int lCount = Math.max(0, d - b);
                            int rCount = Math.max(0, Y.size() - d);

                            count += lCount * rCount;
                        }
                    }
                }
            }
        }

        return count;
    }

    private static HashMap<Character, ArrayList<Integer>> buildFreqMap(String str, int N) {

        HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();

        for(int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<Integer>());
            }

            ArrayList<Integer> list = map.get(c);
            list.add(i);
        }

        return map;
    }

}
