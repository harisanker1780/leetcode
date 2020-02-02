package test;

import java.util.Scanner;

public class CandidateCode {

	public static void main(String args[] ) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int numberOfLines = scanner.nextInt();
		scanner.close();
		
		int numberOfCandiesToMove = 0;
		for(int i = 1, j = 1; i <= numberOfLines && j < numberOfLines; i++, j = j + 2) {
			numberOfCandiesToMove += numberOfLines - j; 
		}
		
		System.out.println(numberOfCandiesToMove);

	}
}
