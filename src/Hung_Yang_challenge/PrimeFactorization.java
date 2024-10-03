package Hung_Yang_challenge;

import java.util.Map;
import java.util.HashMap;

/*
 * 輸入整數n,輸出其質因數分解結果。
 * 質因數:一個大於1的整數,它本身是質數,而且又是某數的因數,則
稱它為某數的質因數。
例(1):5的因數有1、5·而且5是質數,所以5就是5的質因數。
例(2):9的因數有1、3、9,其中3是質數,所以3就是9的質因數。
例(3):21的因數有1、3、7、21·其中3和7都是質數,所以3和7
都是21的質因數。
提示:
質因數分解:把一個整數寫成它的質因數的連乘積,稱為質因數分解。
例(1):把15質因數分解,可以寫成15=3×5。而且15的質因數只有
3和5,共2個。
例(2):把60質因數分解,可以寫成60=2×2×3×5。而且60的質因數
只有2、3、5,共3個。
限制:
1.輸入值範圍2 <= n <= 2147483647
2.執行時間需小於100毫秒
輸入/輸出範例:
1.輸入:600    輸出: 2^3 * 3 * 5^2
2.輸入:924    輸出: 2^2 * 3 * 7 * 11
3.輸入:123456789  輸出:3^2*3607*3803
 */
public class PrimeFactorization {
	public static void main(String[] args) {
		System.out.println(formatPrimeFactors(getPrimeFactors(600)));
		System.out.println(formatPrimeFactors(getPrimeFactors(924)));
		System.out.println(formatPrimeFactors(getPrimeFactors(123456789)));
	}

	private static Map<Integer, Integer> getPrimeFactors(int n) {
		Map<Integer, Integer> primeFactors = new HashMap<>();
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				primeFactors.put(i, primeFactors.getOrDefault(i, 0) + 1);
				n /= i;
			}
		}
		if (n > 1) {
			primeFactors.put(n, 1);
		}
		return primeFactors;
	}

	private static String formatPrimeFactors(Map<Integer, Integer> primeFactors) {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
			if (result.length() > 0) {
				result.append(" * ");
			}
			result.append(entry.getKey());
			if (entry.getValue() > 1) {
				result.append(" ^ ").append(entry.getValue());
			}
		}
		return result.toString();
	}
}
