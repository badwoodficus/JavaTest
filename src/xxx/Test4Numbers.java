package xxx;

public class Test4Numbers {
	public static void main(String[] args) {
		int i;
		int j;
		for (i = 0; i <= 100; i++) {
			for (j = 0; j <= 100; j += 4) {
				if (i == j)
					System.out.println(i);
			}
		}
//		觀念0 是任意正整數的倍數，任意正整數是0 的因數。 
//		※注意：0 不為任何整數之因數，且0 為任何非零整數之倍數。

//		更好的寫法
//		for(int k = 0; k<=100;k++)
//			if(k%4==0)
//				System.out.print(i + " ");
//		for(int m=0; m<=100; m+=4)
//			System.out.print(m +"\n");
	}
}
