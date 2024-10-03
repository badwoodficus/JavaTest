package SoftLeader;

import java.util.HashMap;
import java.util.Map;

public class RightLeft {
	Map<String, Integer> left;
	Map<String, Integer> right;

	public void setUp() {
		left = new HashMap<String, Integer>();
		left.put("a", 1);
		left.put("b", 2);
		left.put("c", 3);

		right = new HashMap<String, Integer>();
		right.put("b", 2);
		right.put("c", 4);
		right.put("d", 5);

	}

	/*
	 * 
	 * 備住：有兩個Map left right，請在Test()內完成程式碼輸出以下內容
	 *
	 * 1.key一樣value不一樣的內容 2.key一樣value一樣的內容 3.key只存在left不存在right的內容
	 * 4.key只存在right不存在left的內容
	 *
	 */

	public void Test() {

//		// answer of 1
//		System.out.println("1.");
//		for (Object key : left.keySet()) {
//			if (right.get(key) != null) {
//				if (!right.get(key).equals(left.get(key))) {
//					System.out.println("left key=" + key + ", value=" + left.get(key));
//					System.out.println("right key=" + key + ", value=" + right.get(key));
//				}
//			}
//		}
//
//		// answer of 2
//		System.out.println("2.");
//		for (Object key : left.keySet()) {
//			if (right.get(key) != null) {
//				if (right.get(key).equals(left.get(key))) {
//					System.out.println("left: key=" + key + ", value=" + left.get(key));
//					System.out.println("right: key=" + key + ", value=" + right.get(key));
//				}
//			}
//		}
//
//		// answer of 3
//		System.out.println("3.");
//		for (Object key : left.keySet()) {
//			if (right.get(key) == null) {
//				System.out.println("left: key=" + key + ", value=" + left.get(key));
//			}
//		}
//
//		// answer of 4
//		System.out.println("4.");
//		for (Object key : right.keySet()) {
//			if (left.get(key) == null) {
//
//				System.out.println("right: key=" + key + ", value=" + right.get(key));
//
//			}
//		}

		System.out.println("1. key一樣value不一樣的內容：");
		for (String key : left.keySet()) {
			if (right.containsKey(key) && !left.get(key).equals(right.get(key))) {
				System.out.println(key + ": left=" + left.get(key) + ", right=" + right.get(key));
			}
		}

		System.out.println("\n2. key一樣value一樣的內容：");
		for (String key : left.keySet()) {
			if (right.containsKey(key) && left.get(key).equals(right.get(key))) {
				System.out.println(key + ": " + left.get(key));
			}
		}

		System.out.println("\n3. key只存在left不存在right的內容：");
		for (String key : left.keySet()) {
			if (!right.containsKey(key)) {
				System.out.println(key + ": " + left.get(key));
			}
		}

		System.out.println("\n4. key只存在right不存在left的內容：");
		for (String key : right.keySet()) {
			if (!left.containsKey(key)) {
				System.out.println(key + ": " + right.get(key));
			}
		}

	}

	public static void main(String[] args) {
		RightLeft demo = new RightLeft();
		demo.setUp();
		demo.Test();

	}
}
