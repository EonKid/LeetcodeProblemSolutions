package com.dns.dsalgo.recursionbacktracking;
/**
 * 
 * Classic exhaustive permutation pattern
 * 
 * 
 * Time Complexity:  O(N!) since there are N! possible permutations, and the algorithm needs to explore each one.
   
   Space Complexity: O(N)
   The maximum depth of the recursion is N, corresponding to the number of elements to be permuted.
   The space complexity is O(N) due to the recursive call stack.

 */
public class Permutation {

	public static void main(String[] args) {
		String inputString = "ABC";
		permute("", inputString);

	}
	
	public static void permute(String outputString, String nextString) {
		if (nextString.length() == 0) {
			System.out.println("[" + outputString + "]");
		}else {
			for (int i = 0; i < nextString.length(); i++) {
				String currentString = outputString + nextString.charAt(i);
				String restString = nextString.substring(0, i) + nextString.substring(i + 1);
				permute(currentString, restString);
			}
		}
	}

	
}
