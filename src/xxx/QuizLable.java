package xxx;

public class QuizLable {
	public static void main(String[] args) {
	String str;
	str = "";
	z:		//lable標籤下一行一定緊接著迴圈
	for (int i = 3; i < 8; i++) {
	    if ( i == 4) break;
	    if (i == 6) break z;
	    str += i;
	}
	System.out.println(str);
	}
}
