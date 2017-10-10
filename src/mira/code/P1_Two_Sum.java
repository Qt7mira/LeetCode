package mira.code;

import java.util.HashMap;

public class P1_Two_Sum {

	/*
	 * 题目：
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you
	 * may not use the same element twice.
	 * 
	 * Example: Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 */

	/*
	 * 创建一个哈希表，在遍历的同时寻找target-i
	 * 时间复杂度和空间复杂度都是O(n)
	 */

	public int[] twoSum(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return null;
		}

		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
			} else {
				map.put(nums[i], i);
			}

		}
		return result;
	}
}
