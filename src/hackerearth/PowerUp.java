package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PowerUp {
	
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int N = Integer.parseInt(line);
        int[] nums = new int[N];

        String[] str = br.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        long result = getPowerUpValue(nums, N);
        System.out.println(result);
    }

    private static long getPowerUpValue(int[] nums, int N) {
        long[] sum = getSum(nums, N);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        long max = Long.MIN_VALUE;
        long sumVal = 0;
        while(i < N) {
            if(map.containsKey(nums[i])) {
                int duplicateIndex = map.get(nums[i]);
                sumVal = Math.max(nums[i], sum[i] - sum[duplicateIndex]);
            } else {
                sumVal = sumVal + nums[i];
            }

            map.put(nums[i], i);

            if(sumVal > max)
                max = sumVal;

            sumVal = sumVal < 0  ? 0 : sumVal;
            i++;
        }

        return max;
    }

    private static long[] getSum(int[] nums, int N) {
        long[] sum = new long[N];
        sum[0] = nums[0];
        for(int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        return sum;
    }

}
