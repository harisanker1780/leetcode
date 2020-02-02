package epi.string;

import meta.Problem;

public class InterConvertStringAndInteger {
	
	@Problem(code = "7.1", name = "Inter convert string and integers")
	public static String intToString(int x) {
		boolean isNegative = false;
		if(x < 0)
		{
			isNegative = true;
		}
		
		StringBuilder builder = new StringBuilder();
		x = Math.abs(x);
		
		if(x == 0) 
		{
			builder.append('0');
		}
		else 
		{
			while(x > 0) 
			{
				int d = x % 10;
				x = x / 10;
				builder.append((char)('0' + d));
			}
		}
		
		if(isNegative) {
			builder.append('-');
		}
		
		builder.reverse();
		return builder.toString();
	}
	
	@Problem(code = "7.1", name = "Inter convert string and integers")
	public static int stringToInt(String s) {
		boolean isNegative = false;
		if(s.charAt(0) == '-') {
			isNegative = true;
		}
		
		int x = 0;
		int base = 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				int d = (c - '0') * base;
				x = x + d;
				base = base * 10;
			}
		}
		
		if(isNegative) {
			x = x * -1;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(intToString(-9680));
		//System.out.println(stringToInt("18") + stringToInt("22"));
	}

}
