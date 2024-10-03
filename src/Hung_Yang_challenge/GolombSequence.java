package Hung_Yang_challenge;

/*
 * 格倫布數列,是一個不遞減整數數列,其定義為:
f(1)=1
f(n)= 是n在數列中出現的次數

其首幾項為:
  n | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12
f(n)| 1 | 2 | 2 | 3 | 3 | 4 | 4 | 4 | 5 |   5 |   5 |  6
試寫一程式,輸入n值計算其f(n)值。

限制:
1.n的範圍:1 <= n <= 2000000000
2.執行時間需小於500毫秒

輸入/輸出範例:
1.輸入:100			輸出:21
2.輸入:9999			輸出:356
3.輸入:123456 		輸出:1684
4.輸入:1000000000 	輸出:438744
 */
public class GolombSequence {

	public static void main(String[] args) {
		System.out.println(calGolomb(100));
		System.out.println(calGolomb(9999));
		System.out.println(calGolomb(123456));
		System.out.println(calGolomb(1000000000));
	}

	private static int calGolomb(int n) {
		if (n == 1)
			return 1; // f(1) = 1

		int[] golomb = new int[n + 1]; // 儲存數字的陣列
		golomb[1] = 1; // 初始化 f(1) = 1

		for (int i = 2; i <= n; i++) {
			golomb[i] = 1 + golomb[i - golomb[golomb[i - 1]]];
		}

		return golomb[n];
	}
}
