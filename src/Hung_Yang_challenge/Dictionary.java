package Hung_Yang_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 給定一個N <= 20000個單字的字典(單字由小寫的'a'到'z'任意組
成),單字標籤從1到N標記。輸入一字串qi,並使用qi查詢字典單字,依據以下條件輸出查詢結果:
A.僅需輸出“前10名”的查詢結果·且僅輸出“單字標籤”。
B."前10名”的所有單字都必須包含字串qi·
C."前10名”中的所有單字都必須按照以下順序排序:
1.長度較短的單字先出現。
2.如果單字的長度相等,則依字母較小的單字先出現。
3.最後依單字標籤較小的單字出現。
D.如果字典中沒有包含子字串qi的單字·則輸出-1·

限制:
1.執行時間需小於500毫秒

輸入/輸出範例:
輸入字典單字:acm,icpc,regional,asia,jakarta,two,thousand,and,
nine, arranged, by, universitas, bina, nusantara, especially, for, you

1.輸入查詢單字qi:a			輸出單字標籤:1 8 4 13 5 10 3 7 14 15
2.輸入查詢單字qi:an		輸出單字標籤:8 10 7 14
3.輸入查詢單字qi:win		輸出單字標籤 :- 1
 */

//表示字典中的單字與標籤，實作Comparable定義排序邏輯
class Word implements Comparable<Word> {
	String content;
	int label;

	public Word(String content, int label) {
		this.content = content;
		this.label = label;
	}

	@Override
	public int compareTo(Word other) {

		if (this.content.length() != other.content.length()) {
			return this.content.length() - other.content.length();
		}
		int strCompare = this.content.compareTo(other.content);
		// 長度不同的時候，相減來比較大小，+-來表示大/小
		if (strCompare != 0) {
			return strCompare;
		}
		// 長度相同的情況，上方計算後strCompare = 0
		return this.label - other.label;
	}
}

public class Dictionary {
	private List<Word> dictionary;

	//構造函式可以接受字串陣列，並且將字串陣列轉換成Word類別實體紀錄標籤
	public Dictionary(String[] words) {
		dictionary = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			dictionary.add(new Word(words[i], i + 1));
		}
	}

	public List<Integer> search(String qi) {
		List<Word> results = new ArrayList<>();
		for (Word word : dictionary) {
			if (word.content.contains(qi)) {  //此行比對字串是否有包含qi，如果有則加入results 
				results.add(word);
			}
		}

		if (results.isEmpty()) {  //若字串陣列內沒有包含qi的單字，則回傳-1
			return Arrays.asList(-1);
		}

		Collections.sort(results);	//對結果進行排序，會使用到Word裡面覆寫的compareTo方法
		List<Integer> labels = new ArrayList<>();
		for (int i = 0; i < Math.min(10, results.size()); i++) {
			labels.add(results.get(i).label);
		}
		return labels;
	}

	public static void main(String[] args) {
		String[] words = { "acm", "icpc", "regional", "asia", "jakarta", "two", "thousand", "and", "nine", "arranged",
				"by", "universitas", "bina", "nusantara", "especially", "for", "you" };

		Dictionary dic = new Dictionary(words);
		System.out.println(dic.search("a"));
		System.out.println(dic.search("an"));
		System.out.println(dic.search("win"));
	}

}
