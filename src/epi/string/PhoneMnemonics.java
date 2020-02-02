package epi.string;

import java.util.ArrayList;
import java.util.List;

public class PhoneMnemonics {
	
	private static final String[] MNEMONIC = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYX"};
	
	public static List<String> phoneMnemonic(String phoneNumber) {
		
		int[] phoneNumberArray = phoneNumber.chars().map(x -> x - '0').toArray();
		int[] indexes = new int[phoneNumberArray.length];
		List<String> result = new ArrayList<String>();
		
		phoneMnemonic(phoneNumberArray, indexes, result);
		
		return result;
	}
	
	private static void phoneMnemonic(int[] phoneNumber, int[] indexes, List<String> result) {
		
		int length = indexes.length;
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < length; i++) {
			String mnemonic = MNEMONIC[phoneNumber[i]];
			builder.append(mnemonic.charAt(indexes[i]));
		}
		
		result.add(builder.toString());
		
		indexes[0] = (indexes[0] + 1) % MNEMONIC[phoneNumber[0]].length();
		int i = 1;
		while(i < length && indexes[i - 1] == 0) {
			indexes[i] = (indexes[i] + 1) % MNEMONIC[phoneNumber[i]].length();
			i++;
		}
		
		i--;
		if(!(i == length - 1 && indexes[i] == 0)) {
			phoneMnemonic(phoneNumber, indexes, result);
		}
	}
	
	public static void main(String[] args) {
	  List<String> result = phoneMnemonic("237"); 
	  int count = 1;
	  for(String s : result) {
		  System.out.println(count++ + ". "  + s); 
	  }
	}

}
