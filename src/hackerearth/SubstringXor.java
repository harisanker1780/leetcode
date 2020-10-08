package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class SubstringXor {

    public static void main(String args[] ) throws Exception {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] line = br.readLine().split(" ");                // Reading input from STDIN
       int N = Integer.parseInt(line[0]);
       int K = Integer.parseInt(line[1]);
       
       int[] nums = new int[N];
       String[] numStr = br.readLine().split(" ");
       for(int i = 0; i < N; i++) {
           nums[i] = Integer.parseInt(numStr[i]);
       }

       TrieNode root = new TrieNode(' ');
       for(int i = 0; i < N; i++) {
           String binary = paddZero(Integer.toBinaryString(nums[i]), 20);
           root.addNumber(binary, i);
       }

       List<Integer> xorSum = new ArrayList<Integer>();
       for(int i = 0; i < N; i++) {
    	   xorSum.add(nums[i]);
       }
       

       for(int l = 2; l <= N; l++) {
           for(int i = 0; (i + l) <= N; i++) {
               int[] result = new int[20];
               root.getNumOfOnes(i, (i + l) - 1, 0, result);

               StringBuilder builder = new StringBuilder();
               for(int j = 0; j < 20; j++) {
                   if(result[j] % 2 == 1) {
                       builder.append('1');
                   } else {
                       builder.append('0');
                   }
               }

               int sum = Integer.parseInt(builder.toString(), 2);
               xorSum.add(sum);
           }
       }

       Collections.sort(xorSum, Collections.reverseOrder());
       System.out.println(xorSum.get(K - 1));

    }

    private static String paddZero(String str, int length) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < (length - str.length()); i++) {
            builder.append('0');
        }

        builder.append(str);
        return builder.toString();
    }

    static class TrieNode {

        char val;
        ArrayList<Integer> indexes;
        HashMap<Character, TrieNode> childrens;

        public TrieNode(char val) {
            this.val = val;
            this.indexes = new ArrayList<>();
            this.childrens = new HashMap<>();
        }

        public void addNumber(String binary, int index) {
            TrieNode root = this;
            for(int i = 0; i < binary.length(); i++) {
                char c = binary.charAt(i);
                if(!root.childrens.containsKey(c)) {
                    root.childrens.put(c, new TrieNode(c));
                }

                TrieNode child = root.childrens.get(c);
                child.indexes.add(index);
                root = child;
            }
        }

        public void getNumOfOnes(int L, int R, int i, int[] result) {
            TrieNode root = this;
            for(char c : root.childrens.keySet()) {
                TrieNode child = root.childrens.get(c);
                if(child.val == '1') {
                    result[i] += getCount(child.indexes, L, R);
                }

                child.getNumOfOnes(L, R, i + 1, result);
            }
        }

        public int getCount(ArrayList<Integer> indexes, int L, int R) {
            int start = 0;
            int end = indexes.size() - 1;

            while(start < indexes.size() && indexes.get(start) < L) {
                start++;
            }

            while(end >= 0 && indexes.get(end) > R) {
                end--;
            }

            int count = Math.max(0, (end - start) + 1);
            return count;
        }
    }
}
