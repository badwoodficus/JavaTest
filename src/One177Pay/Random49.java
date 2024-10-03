package One177Pay;
//寫一隻程式從1~49任取6數字不重複
import java.util.Set;
import java.util.TreeSet;
public class Random49 {
	public static void main(String[] args) {
		Set<Integer> nums = new TreeSet<>();//使用TreeSet避免重複數字加入且可依大小排序
		
		while(nums.size()!=6) {
			int r = (int)(Math.random()*49)+1;
			nums.add(r);
		}
		
		for(int r : nums) {
			System.out.println(r+",");
		}
	}
}
