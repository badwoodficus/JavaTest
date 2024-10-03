package Cube_quiz;

import java.util.*;
public class TestCube {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cube cube1 = new Cube();
		Cube cube2 = new Cube();
		try {
		System.out.println("請輸入立方體邊長：");
		cube1.setLength(sc.nextDouble());
		System.out.println("得到立方體體積為："+cube1.getVolume());
//		Cube2(-4.0d);這個不符合規則會讓使用cube2的人知道輸入參數不對
//		下方是錯誤的寫法
//		cube1.getVolume(sc.nextDouble()); 要把這個包裝在System.out.print裡面印出來
//		throw new CubeException("「正立方體邊長不得為0或是負數");  不應該在這裡宣告丟出甚麼續尋
		}catch(CubeException e){
			e.getMessage();
		}
	}
}
