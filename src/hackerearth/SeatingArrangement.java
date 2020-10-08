package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SeatingArrangement {
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");                // Reading input from STDIN
        long N = Long.parseLong(line[0]);
        int K = Integer.parseInt(line[1]);
        char[] pref = br.readLine().toCharArray();

        long Q = Long.parseLong(br.readLine());
        //long[] seats = new long[N];
        Map<Long, Integer> seats = new HashMap<>();

    	PriorityQueue<Row> rows = new PriorityQueue<Row>();

        rows.add(new Row(0, N - 1));

        for(int i = 1; i <= K; i++) {
            Row row = rows.poll();
            long mid = row.getMid(pref[i - 1]);
            seats.put(mid, i);

            if((mid - 1) >= row.start) {
                rows.add(new Row(row.start, mid - 1));
            }

            if((mid + 1) <= row.end) {
                rows.add(new Row(mid + 1, row.end));
            }
        }
    
        for(long i = 0; i < Q; i++) {
            long q = Long.parseLong(br.readLine());
            if(seats.containsKey(q - 1)) {
            	System.out.println(seats.get(q - 1));
            } else { 
            	System.out.println(-1);
            }
        }
    }

    static class Row implements Comparable<Row> {
        long start, end;

        public Row(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getLength() {
            return (this.end - this.start) + 1;
        }

        public long getMid(char pref) {
            long mid = (start + end) / 2;
            long length = getLength();
            if(length % 2 == 1) {
                return mid;
            } else {
                return pref == 'L' ? mid : mid + 1;
            }
        }
        
		@Override
		public int compareTo(Row other) {
			if(this.getLength() < other.getLength()) {
				return 1;
			} else if(this.getLength() > other.getLength()) {
				return -1;
			} else {
                if(this.start < other.start)
				    return -1;
                else if(this.start > other.start)
                    return 1;
                else
                    return 0;
			}
		}
    }

}
