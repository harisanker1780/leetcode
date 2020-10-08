package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueryProblem {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        
		String[] str = br.readLine().split(" ");
		long[] a = new long[N];
		for(int i = 0; i < N; i++) {
			a[i] = Long.parseLong(str[i]);
		}
		
		int curMid = (N - 1) / 2;
		long leftResult = 1;
		long rightResult = 1;
		for(int i = 0; i <= curMid; i++) {
			leftResult *= a[i];
		}
		
		for(int i = curMid + 1; i < N; i++) {
			rightResult *= a[i];
		}
		
		for(int i = 0; i < M; i++) {
			String[] q = br.readLine().split(" ");
			int type = Integer.parseInt(q[0]);
			if(type == 2) {
				long[] result = findMid(a, leftResult, rightResult, curMid);
				int mid = (int) result[0];
				leftResult = result[1];
				rightResult = result[2];
				System.out.println(mid + 1);
				curMid = mid;
			} else if(type == 1) {
				int index = Integer.parseInt(q[1]) - 1;
				long val = Long.parseLong(q[2]);
				a[index] *= val;
				if(index <= curMid) {
					leftResult = leftResult * val;
				} else {
					rightResult = rightResult * val;
				}
			}
		}
		
	}
	
	public static long[] findMid(long[] a, long leftResult, long rightResult, int curMid) {
		
		int mid = -1;
		while(mid != curMid) {
			
			long diff = Math.abs(leftResult - rightResult);
			long nextLeft = leftResult / a[curMid];
			long nextRight = rightResult * a[curMid];
			long nextDiff = Math.abs(nextLeft - nextRight);
			
			if(nextDiff <= diff) {
				diff = nextDiff;
				mid = mid - 1;
				leftResult = nextLeft;
				rightResult = nextRight;
			} 
			
			if(curMid < a.length - 1) {
				nextLeft = leftResult * a[curMid];
				nextRight = rightResult / a[curMid];
				nextDiff = Math.abs(nextLeft - nextRight);
				
				if(nextDiff < diff) {
					diff = nextDiff;
					mid = mid + 1;
					leftResult = nextLeft;
					rightResult = nextRight;
				}
			}
			
			if(mid <= 1) {
				break;
			}

			curMid = mid;
		} 
		
		
		long[] result = {mid, leftResult, rightResult};
		return result;
	}

}
