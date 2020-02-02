package epi.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import meta.Problem;

public class DeleteDuplicates {
	
	@Problem(code = "6.5", name = "Delete Duplicates from a sorted array")
	public static int deleteDuplicates(List<Integer> A) {
		
		if(A.isEmpty()) {
			return 0;
		}
		
		int nonDuplicateIndex = 0;
		for(int i = 0; i < A.size(); i++) {
			
			A.set(nonDuplicateIndex++, A.get(i));
			
			int j = i;
			for(; j < A.size() && A.get(i) == A.get(j); j++) 
				;
			i = j - 1;
		}
		
		for(int i = nonDuplicateIndex; i < A.size(); i++) 
			A.set(i, 0);
		
		return nonDuplicateIndex;
	}
	
	@Problem(code = "6.5.Variant1", name = "Delete key from array")
	public static int deleteKey(List<Integer> A, Integer key) {
		
		if(A.isEmpty()) {
			return 0;
		}
		
		int index = 0;
		for(int i = 0; i < A.size(); i++) {
			while(i < A.size() && A.get(i) == key)
				i++;
			
			if(i < A.size())
				A.set(index++, A.get(i));
		}
		
		for(int i = index; i < A.size(); i++)
			A.set(i, 0);
		
		return index;
	}
	
	public static void main(String[] args) {
		
		List<Integer> A = new ArrayList<Integer>();
		A.add(0, 1);
		A.add(1, 2);
		A.add(2, 2);
		A.add(3, 8);
		A.add(4, 2);
		A.add(5, 2);
		A.add(6, 2);
		A.add(7, 2);
		/*
		 * A.add(3, 5); A.add(4, 7); A.add(5, 11); A.add(6, 11); A.add(7, 11); A.add(8,
		 * 13);
		 */
	
		System.out.println(Arrays.toString(A.toArray()));
		
		System.out.println(deleteKey(A, 1));
		
		System.out.println(Arrays.toString(A.toArray()));
	}
}
