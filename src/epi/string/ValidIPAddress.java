package epi.string;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {
	
	public static List<String> getValidIPAddress(String s) {
		List<String> result = new ArrayList<String>();
		getValidIPAddress(s, 1, 2, 3, result);
		return result;
	}
	
	public static void getValidIPAddress(String s, int p1, int p2, int p3, List<String> result) {
		int length = s.length();
		if(p1 >= 1 && p1 < p2 && p2 < p3  && p3 < length - 1) {
			int part1 = Integer.parseInt(s.substring(0, p1 + 1));
			int part2 = Integer.parseInt(s.substring(p1 + 1, p2 + 1));
			int part3 = Integer.parseInt(s.substring(p2 + 1, p3 + 1));
			int part4 = Integer.parseInt(s.substring(p3 + 1, length));
			
			if(isValid(part1) && isValid(part2) && isValid(part3)) {
				StringBuilder builder = new StringBuilder();
				builder.append(part1);
				builder.append(".");
				builder.append(part2);
				builder.append(".");
				builder.append(part3);
				builder.append(".");
				builder.append(part4);
				
				result.add(builder.toString());
			}
			
			int temp = p1;
			while(temp < p2) 
				getValidIPAddress(s, ++temp, p2, p3, result);
			
			temp = p2;
			while(temp < p3)
				getValidIPAddress(s, p1, ++temp, p3, result);
			
			temp = p3;
			while(temp < length - 1)
				getValidIPAddress(s, p1, p2, ++temp, result);
			
			//getValidIPAddress(s, p1, p2 + 1, p3, result);
			//getValidIPAddress(s, p1, p2, p3 + 1, result);
		}
	}
	
	private static boolean isValid(int p) {
		return p >= 0 && p <= 255;
	}
	
	public static void main(String[] args) {
		List<String> result = getValidIPAddress("19216811");
		for(String s : result) {
			System.out.println(s);
		}
	}

}
