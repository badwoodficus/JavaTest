package Hung_Yang_challenge;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

/*
 * 在港口的碼頭中通常存放著許多貨櫃,而這些貨櫃最終會裝載在遠洋船
上以便運往國外。
通過公路和鐵路到達碼頭的貨櫃,在到達時會暫時堆放在碼頭中的貨櫃
堆棧上,並等待運送該貨櫃的船隻經過碼頭時,裝載至船上。
貨櫃裝船的時間取決於其貨櫃在貨櫃堆棧的位置,當貨櫃不在堆棧頂部
時,則需移除上層的貨櫃才能裝至船上,進而增加貨櫃裝船的時間。
已知每艘船由A和Z(包括)之間的大寫字母表示,船隻將按字母順序
裝載貨櫃,而每個貨櫃都標有大寫字母,表示需要裝載至哪艘船隻。
試寫一程式,輸入貨櫃到達碼頭的順序,並計算出至少要幾個貨櫃堆
棧,才能讓每艘船裝載貨櫃時,都僅需從貨櫃堆棧最上層取得貨櫃。

限制:
1.貨櫃數量小於1000
2.執行時間需小於100毫秒

輸入/輸出範例:
1.輸入:A							輸出:1
2.輸入:CBACBACBACBACBA              輸出:3
3.輸入:CCCCBBBBAAAA  			輸出:1
4.輸入:ACMICPC 					輸出:4
 */
public class PortStack {
	public static void main(String[] args) {
		System.out.println(minStacks("A"));
		System.out.println(minStacks("CBACBACBACBACBA"));
		System.out.println(minStacks("CCCCBBBBAAAA"));
		System.out.println(minStacks("ACMICPC"));  //此項執行是錯誤的?不確定怎麼改
	}

	// 移除前要先檢查後面是否有同一條船的貨櫃
	// 如果還有的話手上的貨櫃需要stack暫時放置等到同一條船的貨櫃拿完後才可以裝上船
	public static int minStacks(String containers) {
		Stack<Character>[] stacks = new Stack[26];
		Map<Character, Integer> containerCount = new HashMap<>();

		for (char c = 'A'; c <= 'Z'; c++) {
			containerCount.put(c, 0);
		}

		for (char container : containers.toCharArray()) {
			containerCount.put(container, containerCount.get(container) + 1);
		}

		for (int i = 0; i < 26; i++) {
			stacks[i] = new Stack<>();
		}

		int maxStackCount = 0;

		for (char container : containers.toCharArray()) {
			boolean placed = false;

			for (int i = 0; i < maxStackCount; i++) {
				if (stacks[i].isEmpty() || stacks[i].peek() <= container) {
					stacks[i].push(container);
					placed = true;
					break;
				}
			}

			if (!placed) {
				stacks[maxStackCount].push(container);
				maxStackCount++;
			}

			containerCount.put(container, containerCount.get(container) - 1);

			if (containerCount.get(container) == 0) {
				for (Stack<Character> stack : stacks) {
					if (!stack.isEmpty() && stack.peek() == container) {
						stack.clear();
					}
				}
			}
		}

		return maxStackCount;
	}
}
