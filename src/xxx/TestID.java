package xxx;

import java.util.Scanner;
//驗證身份證字號的java
public class TestID {
	public static void main(String[] args) {
		String idRegex = "^[A-Za-z][1-2]\\d{8}$";
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入身分證字號: ");
		String id = sc.next();
		
		if(id.matches(idRegex)) {
			System.out.println("通過驗證!");
		}else {
			System.out.println("格式錯誤");
		}
	}
}
