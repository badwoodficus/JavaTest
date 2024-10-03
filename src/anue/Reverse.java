package anue;
/*
 * 可以被遞迴呼叫,將字串
"www.cnyes.com"逐字反轉為:"moc.seync.www"
 */
public class Reverse {
	public static void main(String[] args) {
		String ori = "www.cnyes.com";
		String rev = recursion(ori);
		System.out.println(rev);
	}
	
	public static String recursion(String str) {
		// 基本情況：如果字串是空的或只有一個字元，則返回該字串
		if(str.isEmpty()) {
			return str;
		}
		// 遞迴呼叫：將字串的第一個字元移到最後，然後反轉剩餘的字串
		return recursion(str.substring(1)) + str.charAt(0);
	}
}
