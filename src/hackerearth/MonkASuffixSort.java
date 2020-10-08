package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Monk loves to play games. On his birthday, his friend gifted him a string S. Monk and his friend started playing a new game called as Suffix Game. In Suffix Game, Monk's friend will ask him lexicographically  smallest suffix of the string S. Monk wants to eat the cake first so he asked you to play the game.

Input Format:
First line contains a string S () and an integer k ().

Output Format:
Print the lexicographically  smallest suffix of the string S.

Note:
Those who are not familiar with suffix and lexicographical order, can read about it from https://en.wikipedia.org/wiki/Suffix and https://en.wikipedia.org/wiki/Lexicographical_order.

Sample Input
aacb 3
Sample Output
b
Explanation
All the suffices of the string are:
aacb
acb
cb
b

After sorting the order of the suffices will be:
aacb
acb
b
cb

 smallest suffix will be b.
 *
 */
public class MonkASuffixSort {
	
	public static void main(String args[] ) throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" "); 
        String s = line[0];
        Integer k = Integer.parseInt(line[1]);

		printSmalletSuffix(s, k);
    }

	
	public static void printSmalletSuffix(String s, int k) {
		int N = s.length();
		Integer[] suffixStart = new Integer[N];
		for(int  i = 0; i < N; i++) {
			suffixStart[i]  = i;
		}
		
		Arrays.sort(suffixStart, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = s.substring(o1);
				String s2 = s.substring(o2);
				return s1.compareTo(s2);
			}
		});
		
		System.out.println(s.substring(suffixStart[k - 1]));
	}
}
