package Hung_Yang_challenge;

import java.util.Stack;

/*
 * 試寫一程式,輸入一運算式(expression),運算式包含整數,加減運算
與括號的組合。請依由左而右計算及括號內的運算優先計算為原則,計
算此運算式的數值。
限制:
1.執行時間需小於100毫秒
輸入/輸出範例:
1.輸入:5-(6-(3+2))				輸出:4
2.輸入:100-(13-7+((135-68)-22))  輸出:49
3.輸入:(2+6-10)-(12-4-(20-11))   輸出 :- 1
 */
public class ExpressionEvaluator {

    // 方法：計算運算式的值
    public static int evaluate(String expression) {
        Stack<Integer> numbers = new Stack<>(); // 用於存放數字
        Stack<Character> operators = new Stack<>(); // 用於存放運算符
        int index = 0;

        while (index < expression.length()) {
            char ch = expression.charAt(index);

            if (Character.isDigit(ch)) {
                int num = 0;
                while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                    num = num * 10 + (expression.charAt(index) - '0');
                    index++;
                }
                numbers.push(num);
                continue;
            }

            if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.pop();
            } else if (ch == '+' || ch == '-') {
                while (!operators.isEmpty() && precedence(ch, operators.peek())) {
                    numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(ch);
            }
            index++;
        }

        while (!operators.isEmpty()) {
            numbers.push(calculate(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    // 方法：計算單個運算
    private static int calculate(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            default:
                return 0;
        }
    }

    // 方法：判斷運算優先級
    private static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return true;
    }

    // 主方法：測試輸入
    public static void main(String[] args) {
        String expression1 = "5-(6-(3+2))";
        System.out.println(evaluate(expression1)); // 輸出: 4

        String expression2 = "100-(13-7+((135-68)-22))";
        System.out.println(evaluate(expression2)); // 輸出: 49

        String expression3 = "(2+6-10)-(12-4-(20-11))";
        System.out.println(evaluate(expression3)); // 輸出: -1
    }
}
