package LEO;

public class Test_AVO_sequence {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 10 };
		int maxLength = countLongestAVO(nums);
		System.out.println("輸入:{ 1, 2, 3, 4, 5, 4, 3, 2, 1, 10 }"+" 輸出: "+maxLength);
	}

	private static int countLongestAVO(int[] nums) {

		int n = nums.length;

		if (n < 3)
			return 0;

		int[] inc = new int[n];
		int[] dec = new int[n];

		for (int i = 0; i < n; i++) {
			inc[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			dec[i] = 1;
		}

		// 找遞增數列
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if ((nums[i] > nums[j]) && (inc[i] < inc[j] + 1)) {
					inc[i] = inc[j] + 1;
				}
			}
		}

		// 找遞減數列
		for (int i = n - 2; i > 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if ((nums[i] > nums[j]) && (dec[i] < dec[j] + 1)) {
					dec[i] = dec[j] + 1;
				}
			}
		}

		int count = 0;
		// 計算長度
		for (int i = 0; i < n; i++) {
			if (inc[i] > 1 && dec[i] > 1) {
				count = Math.max(count, inc[i] + dec[i] - 1);
			}
		}

		return count;
	}
}
