package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BreakTheDoor {
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");                // Reading input from STDIN
        int N = Integer.parseInt(line[0]);
        long D = Long.parseLong(line[1]);
        int K = Integer.parseInt(line[2]);

        PriorityQueue<Hammer> hammers = new PriorityQueue<Hammer>();
      

        String[] powers = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            long power = Long.parseLong(powers[i]);
            hammers.add(new Hammer(i, power));
        }

        int count = 0;
        while(K > 0 && D > 0 && hammers.size() > 0) {
            Hammer hammer = hammers.poll();
            D = Math.min(0, D - hammer.hit());
            K--;
            count++;

            if(hammer.power > 0) {
                hammers.add(hammer);
            }
        }

        if(K >= 0 && D == 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    static class Hammer implements Comparable<Hammer> {

        int id;
        long power;

        public Hammer(int id, long power) {
            this.id = id;
            this.power = power;
        }

        public long hit() {
            if(power > 0) {
                long p = power;
                power = power / 2;
                return p;
            } else {
                return 0;
            }
        }

		@Override
		public int compareTo(Hammer other) {
            if(this.power < other.power) {
                return 1;
            } else if(this.power > other.power) {
                return -1; 
            } else {
                return 0;
            }
		}
    }

}
