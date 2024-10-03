package Hung_Yang_challenge;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 輸入一整數數列，其數列中所有整數皆不重複出現，輸出所有最長遞增子數列的數量。
 * 例如：數列"0","-3","1","4"所有的遞增子數列為
 * "0", "1"
 * "0", "1", "4"
 * "0", "4"
 * "-3", "1"
 * "-3", "1", "4"
 * "-3", "4"
 * "1", "4"
 * 其中最長的遞增子數列有兩種"0", "1", "4"與"-3", "1", "4"
 * 故最長遞增子數列數量為2										
 * 
 * 規則：執行時間需小於100ms
 * 輸入:"0", "-2", "5", "1", "2", "4", "3"  輸出：4
 * 輸入:"11", "10", "-10", "-1", "19", "3", "17", "14", "1"  輸出：2
 */
//不改變數列順序的情況下找出最長的遞增數列
public class Increment {
	public static void main(String[] args) {
		int[] arr1 = { 0, -2, 5, 1, 2, 4, 3 };
		int[] arr2 = { 11, 10, -10, -1, 19, 3, 17, 14, 1 };
		System.out.println(findIncrement(arr1));
		System.out.println(findIncrement(arr2));
	}

	private static int findIncrement(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int n = nums.length;
		int[] lengths = new int[n]; // lengths[i] = length of longest ending in nums[i]找出直到i之前最長的遞增數列
		int[] counts = new int[n]; // count[i] = number of longest ending in nums[i] 找出直到i之前最長的遞增數列數量

		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			lengths[i] = 1;
			counts[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) { //當原本數列的第i項大於第j項(後面的數字大於前面的數字)
					if (lengths[j] + 1 > lengths[i]) {
						lengths[i] = lengths[j] + 1;  	//如果能形成更長的子數列，更新lengths[i]
						counts[i] = counts[j];			//更新counts[i]
					} else if (lengths[j] + 1 == lengths[i]) {
						counts[i] += counts[j];			//如果有相同長度的子數列，更新counts[i]
					}
				}
			}
			maxLength = Math.max(maxLength, lengths[i]); 	//使用lengths[i] 找到最大長度的子數列，並累加對應的值獲得最大長度
		}

		int total = 0;
		for (int i = 0; i < n; i++) {
			if (lengths[i] == maxLength) {
				total += counts[i];
			}
		}
		return total;

	}
}
