package Hung_Yang_challenge;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

/*
 * 在基因的序列中,DNA是由四種鹼基所編排而成,四種鹼基分別為腺嘌
呤(A)、胸腺嘧啶(T)、胞嘧啶(C)和鳥嘌呤(G)。
遺傳學家經常比較DNA鏈,並找到兩條DNA鏈中最長的共同鹼基序
列·例如:兩條DNA鏈atgc和tga中最長的共同鹼基序列是tg。
另外DNA鏈還可能存在兩個以上最長且具有相同長度的共同鹼基序
列·例如:在atgc和gctg中,最長的共同鹼基序列是gc和tg。
試寫一程式,輸入代表DNA鏈的兩個字串,並按字母順序輸出所有最
長的共同鹼基序列。
限制:
1.DNA鏈字串長度最多 300字元
2.執行時間需小於100毫秒
輸入/輸出範例:
1.輸入:atgc tga    輸出:tg
2.輸入:atgc gctg   輸出:gc tg
3.輸入:atgcaattggtagccatatag gctggtacttggcatggtcagtatag 輸出:tatag tggta
 */
public class GeneString {
	
	public static void main(String[] args) {
//		System.out.println(findLCS("atgc","tga"));
//		System.out.println(findLCS("atgc","gctg"));
		System.out.println(findLCS("atgcaattggtagccatatag","gctggtacttggcatggtcagtatag")); //這邊驗證沒過，currentLCS取樣有問題
	}
	
	private static List<String>findLCS(String dna1, String dna2){
		int m = dna1.length();
		int n = dna2.length();
		
		int[][] dp = new int[m+1][n+1]; //儲存長度的二維陣列
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n ; j++) {
				if(dna1.charAt(i-1)==dna2.charAt(j-1)) {  //這樣子取樣會變成i 跟 j是不連續的做比對
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		Set<String> lcsSet = new HashSet<>();
		findSameGene(dna1, dna2, m, n, dp, "", lcsSet);
		
		List<String> lcsList = new ArrayList<>(lcsSet);
		lcsList.sort(String::compareTo);
		return lcsList;
	}
	
	private static void findSameGene(String dna1, String dna2, int i , int j, int[][] dp, String currentLCS, Set<String> lcsSet) {
		while(i>0 && j>0) {
			if(dna1.charAt(i-1)== dna2.charAt(j-1)) {
				currentLCS = dna1.charAt(i-1) + currentLCS;
				i--;
				j--;
			}else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			}else if(dp[i-1][j] < dp[i][j-1]) {
				j--;
			}else {
				findSameGene(dna1, dna2, i-1 , j , dp, currentLCS, lcsSet);
				findSameGene(dna1, dna2, i , j-1 , dp, currentLCS, lcsSet);
				return;
			}
		}
		
		if(!currentLCS.isEmpty() && (dna1.contains(currentLCS) || dna2.contains(currentLCS))) {
			lcsSet.add(currentLCS);
		}
	}
}
