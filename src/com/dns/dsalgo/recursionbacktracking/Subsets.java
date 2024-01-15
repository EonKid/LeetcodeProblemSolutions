package com.dns.dsalgo.recursionbacktracking;

/**
 * Classic exhaustive subset pattern
 * 
 * Time Complexity: 2^N
   There are 2^N possible subsets for a set of N elements (including the empty set and the set itself).
 	
   Space Complexity: O(N)
   The space complexity is O(N) due to the recursive call stack.	
 
 * 
 * 
 */
public class Subsets {

	public static void main(String[] args) {
		subSets("", "ABC");

	}
	
	public static void subSets(String outputString, String nextString) {
		if (nextString.length() == 0) {
			System.out.println("{" + outputString + "}");
		}else {
			subSets(outputString + nextString.charAt(0), nextString.substring(1));
			subSets(outputString, nextString.substring(1));
		}
	}

}
