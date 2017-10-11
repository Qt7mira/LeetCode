package mira.code;

import java.util.HashMap;

public class P3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcac"));

	}

	public static int lengthOfLongestSubstring(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		int head = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) + 1 > head) {
					head = map.get(c) + 1;
				}
			}
			map.put(c, i);
			String str = s.substring(head, i + 1);
			max = Math.max(max, str.length());
		}
		System.out.println(map.size());
		return max;

	}

	/*
	 * 通过对代码的分析，认为最终的结果3，应该是bca，而不是abc。
	 * 如果希望输出该子串，则应该定义变量str，判断max的大小情况，从而选择对应的子串。
	 */
}
