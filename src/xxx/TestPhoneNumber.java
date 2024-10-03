package xxx;

import java.util.Scanner;
//驗證手機號碼格式
public class TestPhoneNumber {
	
	public static void main(String[] args) {
		String regex = "^09\\d[0-9]\\d{6}$";
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入手機號碼");
		String tel = sc.next();
		
		if(tel.matches(regex)) {
			System.out.println("通過");
		}else {
			System.out.println("不符合格式");
		}
	}
}
