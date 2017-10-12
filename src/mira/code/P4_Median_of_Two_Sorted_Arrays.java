package mira.code;

public class P4_Median_of_Two_Sorted_Arrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		/*
		 * 确保m <= n
		 * 
		 * 如果m > n,则j = (m+n+1)/2可能会为负
		 */
		if (m > n) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}

		/*
		 * halfLen应该是为了无论奇偶，都能得到对应的整数值，才进行了+1操作。
		 * 
		 * 如3 + 1 / 2 = 2; 4 + 1 /2 = 2
		 */
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin < iMax) {
			int i = (iMax + iMin) / 2;
			int j = halfLen - i;
			if (i < iMax && nums2[j - 1] > nums1[i]) {
				iMin += 1;
			} else if (i > iMin && nums1[i - 1] > nums2[j]) {
				iMax -= 1;
			} else {
				int maxLeft = 0;
				int minRight = 0;
				if (i == 0) {
					maxLeft = nums2[j - 1];
				} else if (j == 0) {
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
				}
				// 考虑到nums1和num2的数值之和为单数，则maxLeft此时已经是中位数了。
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				if (i == m) {
					minRight = nums2[j];
				} else if (j == n) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums1[i], nums2[j]);
				}
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}
}
