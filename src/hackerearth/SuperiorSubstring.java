package hackerearth;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class SuperiorSubstring {
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int T = Integer.parseInt(line);

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String s = br.readLine().trim();
            int length = getSuperiorLength(s, N);
            System.out.println(length);
        }
    }

    private static int getSuperiorLength(String s, int N) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        int maxLength = 0;

        for(int start = 0; start < N; start++) {
            if(start > 0) {
                map.put(s.charAt(start - 1), map.get(s.charAt(start - 1)) - 1);
            }

            TreeSet<Letter> set = new TreeSet<Letter>(new Comparator<Letter>() {
                @Override
                public int compare(Letter o1, Letter o2) {
                    if(o1.count < o2.count) {
                        return 1;
                    } else if(o1.count > o2.count) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            for(char c : map.keySet()) {
                if(map.get(c) > 0) {
                    set.add(new Letter(c, map.get(c)));
                }
            }

            for(int end = N - 1; end >= start; end--) {
                int length = (end - start) + 1;
                if(length <= maxLength) {
                    break;
                }

                Letter first = set.first();
                if(first.count >= length / 2) {
                    maxLength = length;
                }

                char c = s.charAt(end);
                Optional<Letter> letterOpt = set.stream().filter(l -> l.c == c).findFirst();
                if(letterOpt.isPresent()) {
                	Letter letter = letterOpt.get();
                    set.remove(letter);
                    letter.count--;
                    set.add(letter);
                }
            }
        }

        return maxLength;
    }

    static class Letter {
        char c;
        int count;

        public Letter(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
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
			Letter other = (Letter) obj;
			if (c != other.c)
				return false;
			return true;
		}
    }

}
