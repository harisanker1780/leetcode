package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	
	private static Map<Integer, String[]> map = new HashMap<Integer, String[]>();
	
	
	public LetterCombinationsOfAPhoneNumber() {
		String[] a2 = {"a", "b", "c"};
		map.put(2, a2);
		String[] a3 = {"d", "e", "f"};
		map.put(3, a3);
		String[] a4 = {"g", "h", "i"};
		map.put(4, a4);
		String[] a5 = {"j", "k", "l"};
		map.put(5, a5);
		String[] a6 = {"m", "n", "o"};
		map.put(6, a6);
		String[] a7 = {"p", "q", "r", "s"};
		map.put(7, a7);
		String[] a8 = {"t", "u", "v"};
		map.put(8, a8);
		String[] a9 = {"w", "x", "y", "z"};
		map.put(9, a9);
	}
	
	public List<String> letterCombinations(String digits) {
        Integer nums[] = new Integer[digits.length()];
        Integer[] indexes = new Integer[digits.length()];
        for(int i = 0; i < digits.length(); i++ ) {
        	String c = "" + digits.charAt(i);
        	nums[i] = Integer.parseInt(c);
        	indexes[i] = 0;
        }
        
        return letterCombinations(nums, indexes);
    }
	
	private List<String> letterCombinations(Integer nums[], Integer[] indexes) {
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < nums.length; i++) {
			Integer num = nums[i];
			Integer index = indexes[i];
			if(index < map.get(num).length) {
				String letter = map.get(num)[index];
				indexes[i]++;
				List<String> list = letterCombinations(nums, indexes);
				for(String l : list) {
					result.add(letter + l);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
		List<String> list = sol.letterCombinations("23");
		for(String s : list) {
			System.out.println(s);
		}
	}

}
