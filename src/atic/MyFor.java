package atic;

public class MyFor {
	public static void main(String argv[]) {
		int i;
		int j;
		outer: for (i = 1; i < 3; i++)
			inner: for (j = 1; j < 3; j++) {
				if (j == 2)
					continue outer;
				System.out.println("Value for i=" + i + " Value for j=" + j);
			}
		String s=new String("Bicycle");
		int iBegin=1;
		char iEnd=3;
		System.out.println(s.substring(iBegin,iEnd));
		System.out.println(4 | 3);
		char initial = '2';
		switch(initial) {}
	}
}
