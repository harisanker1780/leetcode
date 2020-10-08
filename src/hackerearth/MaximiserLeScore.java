package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximiserLeScore {
	
public static void main(String args[] ) throws Exception {
        
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();                // Reading input from STDIN
//        int T = Integer.parseInt(line);
//        for(int t = 0; t < T; t++) {
//            String[] str = br.readLine().split(" ");
//            int N = Integer.parseInt(str[0]);
//            int K = Integer.parseInt(str[1]);
//            String[] valStr = br.readLine().split(" ");
//            long[] values = new long[N];
//            for(int i = 0; i < N; i++) {
//                values[i] = Long.parseLong(valStr[i]);
//            }
//            String turn = br.readLine().trim();
//            boolean headFirst = turn.equals("HEADS") ? true : false;
//
//            printMax(values, N, K, headFirst) ;
//        }
	
	System.out.println(Integer.MAX_VALUE);
        
    }

    private static void printMax(long[] values, int N, int K, boolean headFirst) {

        long headSum = 0;
        long tailSum = 0;

        PriorityQueue<Ball> valueQueue = new PriorityQueue<Ball>(new Comparator<Ball>() {
            public int compare(Ball b1, Ball b2) {
                if(b1.value < b2.value) {
                    return 1;
                } else if(b1.value > b2.value) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });


        PriorityQueue<Ball> digitSumQueue = new PriorityQueue<Ball>(new Comparator<Ball>() {
            public int compare(Ball b1, Ball b2) {
                if(b1.digitSum < b2.digitSum) {
                    return 1;
                } else if(b1.digitSum > b2.digitSum) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for(int i = 0; i < N; i++) {
            Ball ball = new Ball(values[i]);
            valueQueue.add(ball);
            digitSumQueue.add(ball);
        }

        while(!valueQueue.isEmpty() && !digitSumQueue.isEmpty()) {
            if(headFirst) {
                headSum += selectBallsByVal(valueQueue, digitSumQueue, K);
                tailSum += selectBallsByDigitSum(valueQueue, digitSumQueue, K);
            } else {
                tailSum += selectBallsByDigitSum(valueQueue, digitSumQueue, K);
                headSum += selectBallsByVal(valueQueue, digitSumQueue, K);
            }
        }

        System.out.println(headSum + " " + tailSum);
    }

    private static long selectBallsByVal(PriorityQueue<Ball> valueQueue, PriorityQueue<Ball> digitSumQueue, int k) {

        long sum = 0;
        while(!valueQueue.isEmpty() && k > 0) {
            Ball ball = valueQueue.poll();
            sum  = sum + ball.value;
            digitSumQueue.remove(ball);
            k--;
        }

        return sum;
    }


    private static long selectBallsByDigitSum(PriorityQueue<Ball> valueQueue, PriorityQueue<Ball> digitSumQueue, int k) {

        long sum = 0;
        while(!digitSumQueue.isEmpty() && k > 0) {
            Ball ball = digitSumQueue.poll();
            sum  = sum + ball.value;
            valueQueue.remove(ball);
            k--;
        }

        return sum;
    }

    static class Ball {

        long value;
        int digitSum;

        public Ball(long value) {
            this.value = value;
            setDigitSum();
        }

        public long getValue() {
            return value;
        }

        public int getDigitSum() {
            return digitSum;
        } 

        private void setDigitSum() {
            int sum = 0;
            int base = 10;
            long num = value;
            while(num > 0) {
                sum = sum + ((int)(num % base));
                num = num / base;
            }

            this.digitSum = sum;
        }
    }

}
