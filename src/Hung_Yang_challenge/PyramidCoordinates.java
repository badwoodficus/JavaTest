package Hung_Yang_challenge;
/*
 * 輸入一正整數n·且n>=2,可用*印出n層的金字塔圖形·請依序輸出金字塔圖形中各層的*座標·
例如n=5,金字塔圖形如下:
其各層的*座標為:
(1,5),(2,4),(2,6),(3,3),(3,7),(4,2),(4,8),(5,1),(5,2),(5,3),(5,4),(5,5),(5,6),(5,7),(5,8),(5,9)
限制:
1.執行時間需小於100毫秒
輸入/輸出範例 ::
1.輸入:2			輸出:(1,2),(2,1),(2,2),(2,3)
2.輸入:3 			輸出:(1,3),(2,2),(2,4),(3,1),(3,2),(3,3),(3,4),(3,5)
3.輸入:5 			輸出:(1,5),(2,4),(2,6),(3,3),(3,7),(4,2),(4,8),(5,1),(5,2),(5,3),(5,4),(5,5),(5,6),(5,7),(5,8),(5,9)
 */
import java.util.List;
import java.util.ArrayList;

public class PyramidCoordinates {
	public static void main(String[] args) {
		printPyramidCoordinates(2);
		printPyramidCoordinates(3);
		printPyramidCoordinates(5);
	}
	
	public static void printPyramidCoordinates(int n) {
		List<String> coordinates = new ArrayList<>();
		for(int i = 1; i <=n ; i ++) {
			int start = n - i + 1;
			int end = n + i - 1;
			for(int j = start; j<=end ; j++) {
				if(i == n) { //判斷為最底下一行的時候把所有座標打印出來
				coordinates.add("(" + i +"," + j + ")" );
				}else if(j == start || j == end) {//其他情況只要打印出頭尾的座標
					coordinates.add("(" + i +"," + j + ")" );
				}
			}
		}
		System.out.println("輸出: "+ String.join(",", coordinates));
	}
}
