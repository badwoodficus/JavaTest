/**
 * 
 */
package xxx;

/**
 * 寫出一個3*3*3的陣列xyz 其中x,y產生隨機亂數介於1~30 z的值為同位置x + y 的和
 */
public class TestArray {
	public static void main(String[] args) {
//		int r1 = (int)(Math.random()*31);
		int arrayX[][] = new int[3][3];
		int arrayY[][] = new int[3][3];
		int arrayZ[][] = new int[3][3];
		for (int i = 0; i < arrayX.length; i++) {
			for (int j = 0; j < arrayX.length; j++) {
				arrayX[i][j] = (int) (Math.random() * 31);
			}
		}
		for (int i = 0; i < arrayY.length; i++) {
			for (int j = 0; j < arrayY.length; j++) {
				arrayY[i][j] = (int) (Math.random() * 31);
			}
		}
		for (int i = 0; i < arrayZ.length; i++) {
			for (int j = 0; j < arrayZ.length; j++) {
				arrayZ[i][j] = arrayX[i][j] + arrayY[i][j];
				System.out.print(arrayZ[i][j] + "\t");
			}
			System.out.println();
		}
	}

}

// int r = (int)(Math.random()* 想要產生數量的個數) + 起始值;