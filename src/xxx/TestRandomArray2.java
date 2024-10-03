package xxx;

public class TestRandomArray2 {
	
	public int[][] getRandomArray(){
		int [][] array= new int[3][3];
		for(int i=0;i<array.length;i++) {
			for(int j = 0;j<array[i].length;j++) {
				array[i][j] = (int)(Math.random()*31);
			}
		}
		return array;
	}
//讓區域變數可以跨方法使用，則在另一個方法宣告參數時使用參數返回值
	public void printArray(int[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j = 0; j< array.length;j++) {
				System.out.print(array[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("===================");
	}
	
	public static void main(String[] args) {
		TestRandomArray2 tra = new TestRandomArray2();		//建立實體來使用上面宣告的方法
		int[][] x = tra.getRandomArray();					//呼叫方法提供資料
		int[][] y = tra.getRandomArray();
		int[][] z = new int[3][3];							//準備容器進行運算
		for(int i=0;i<z.length;i++) {
			for(int j = 0; j< z.length;j++) {
				z[i][j] = x[i][j]+y[i][j];
			}
		}
		tra.printArray(x);
		tra.printArray(y);
		tra.printArray(z);
	}
}
