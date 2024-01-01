package com.dns.arrayandstrings;

import java.util.HashMap;


/**
 * 
 * URL:  https://leetcode.com/problems/two-sum/description/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
 * 1. Two Sum
Solved
Easy

Topics
Companies

Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 
 */

public class PN_1_TwoSum {
	
	 public static void main(String[] args) throws Exception{
		  int[] nums1 = {2, 7, 11, 15};
	        int target1 = 9;
	        int[] result1 = twoSum(nums1, target1);
	        System.out.println("Example 1: [" + result1[0] + ", " + result1[1] + "]");
	 }
	
	 public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (hashMap.containsKey(complement)) {
				return new int[] {i, hashMap.get(complement)};
			}
			hashMap.put(nums[i], i);
		}
		return new int[]{};
	 }

}
