package Hung_Yang_challenge;

import java.util.Stack;

/*
 * 一字串由()[]{}三種括號組成,請試寫一程式,請驗證該字串中的括號
是否合法配對·
限制:
1.該字串最大長度為128字元
2.執行時間需小於100毫秒
輸入/輸出範例:
1.輸入:(([O])))    輸出:false
2.輸入:({[[]]}     輸出:true
3.輸入:(([([O})]))  輸出:false
 */
public class Test3Bracket {
	public static void main(String[] args) {
		System.out.println(checkBrackets("(([O])))"));
		System.out.println(checkBrackets("{[[]]}"));
		System.out.println(checkBrackets("(([([O})]))"));
	}

	private static boolean checkBrackets(String brackets) {
		
		if(brackets.length() == 0 || brackets.isEmpty()) {
			return false;
		}
		
		//判斷字串裡面是否只有括號
		String bracketsMatch = "^[\\{\\}\\[\\]\\(\\)]*$";
		if(!brackets.matches(bracketsMatch)) {
			return false;
		}
		
		//判斷字串長度
		if (brackets.length() > 128) {
			throw new IllegalArgumentException("字串長度超過限制");
		}

		// 判斷括號是否成對出現
		Stack<Character> stack = new Stack<>();
		for (char c : brackets.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
					return false;
				}
			}
		}
		return stack.isEmpty(); //兩兩相配後符合規則的stack裡面是空

	}
}
