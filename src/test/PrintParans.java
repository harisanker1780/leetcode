package test;

import java.util.HashSet;
import java.util.Set;

public class PrintParans {
	
	public static void main(String[] args) {
		
		Set<String> result = getParans(10);
		for(String s : result) {
			System.out.println(s);
		}
	}
	
	private static Set<String> getParans(int n) {
		
		Set<String> result = new HashSet<String>();
		if(n == 1) {
			result.add("()");
			return result;
		}
		
		Set<String> partials = getParans(n - 1);
		for(String p : partials) {
			
			// Add at the beginning
			result.add("()" + p);
			
			for(int i = 0; i < p.length(); i++) {
				char c = p.charAt(i);
				if(c == '(') {
					// Add inside every pair
					String s = insertAfter(p, i);
					result.add(s);
				}
			}
		}
		
		return result;
	}

	private static String insertAfter(String p, int i) {
		String start = p.substring(0, i + 1);
		String end = p.substring(i + 1, p.length());
		return start  + "()" + end;
	}
}
