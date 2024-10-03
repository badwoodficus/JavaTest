package Hung_Yang_challenge;
/*
 * 假設有5種類型的硬幣:50、25、10、5和1,而我們可以使用這些硬
幣的不同組合得到相同的總和金額。
例如,我們所需金額為11元,那麼我們可以有以下四種組合方式得到
此金額:
"一個10元硬幣和一個1元硬幣"·
"二個5元硬幣和一個1元硬幣"、
"一個5元硬幣和六個1元硬幣"、
"十一個1元硬幣"
試寫一程式,找出輸入金額總共有多少種的硬幣組合方式。

限制:

1.輸入金額最大值為 7489
2.執行時間需小於1000毫秒

輸入/輸出範例:
1.輸入:11			輸出:4
2.輸入:26 		輸出:13
3.輸入:1000 		輸出:801451
 */
public class CoinCollections {
	public static void main(String[] args) {
		System.out.println(countCombinations(11));
		System.out.println(countCombinations(26));
		System.out.println(countCombinations(1000));
	}
	
	private static int countCombinations(int amount) {
		int[] dp = new int[amount+1];
		int[] coins = {1,5,10,25,50};
		
		dp[0] = 1;
		for(int coin : coins) {
			for(int i= coin; i<= amount;i++) {
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
}
