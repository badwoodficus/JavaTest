package Hung_Yang_challenge;

import java.awt.geom.*;

/*
 * 一座位於熱帶國家的海上小島,為擴展旅遊業務,打算新建一條新的飛
機跑道,以便容納更大的飛機起降,目前工程師已測量出n個小島周圍
的座標,請試寫一程式,依序輸入小島周圍的點座標,在依據點座標計
算出島上能夠興建的最長飛機跑道長度。另外由於預算限制,所以飛機
跑道不得橫跨在大海之上,但允許沿著島嶼的邊界興建。
限制:
1.小島周圍的座標數為3 <= n <= 200
2.執行時間需小於100毫秒
3.輸出的最長長度需四捨五入到小數第6位
輸入/輸出範例:
1. 輸入:"0 20”,"40 0","40 20", "50 40","50 70", "30 40", "0 50”輸
出:64.031242
2.輸入:"0 2017","-2017 -2017","2017 0"
輸出:4510.149111
3. 輸入:"-35 15", "-25 45", "0 25", "25 25", "35 15", "35 -15", "25 -
45","10 -25","0 10" 輸出:84.852814
 */
public class NewAirport {

	public static void main(String[] args) {
		String[] locations1 = { "0 20", "40 0", "40 20", "50 40", "50 70", "30 40", "0 50" };
		Point2D.Double[] points = new Point2D.Double[locations1.length];
		for (int i = 0; i < locations1.length; i++) {
			String[] coordinates = locations1[i].trim().split(" ");
			points[i] = new Point2D.Double(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
		}
		System.out.printf("%.6f\\n", distance(points)); 		//計算結果有誤差，不確定原因
	}

	private static double distance(Point2D.Double[] points) {
		double airstrip = 0.0;
		int n = points.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double runway = points[i].distance(points[j]);
				if (runway > airstrip) {
					airstrip = runway;
				}
			}
		}

		return airstrip;
	}
}
