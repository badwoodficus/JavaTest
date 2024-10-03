package xxx;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
//使用Set 設計程式每次執行都能隨機顯示出6個不重複的數字，介於1~49之間
public class RandomSix {
    public static void main(String[] args) {
        Random rand = new Random();
        Set<Integer> set = new HashSet<Integer>();

        while (set.size() < 6) {  
//        	不確定會執行幾次才滿足六個不重複數字，所以使用while,
//        	注意最後一圈產生第六個數之後進入條件判斷才知道要不要跑下一圈，停止迴圈前有產生值
            int num = rand.nextInt(49) + 1;
            set.add(num);		//不重複的數字才會加入 set，使set.size()+1
        }
        System.out.println("六個不重複的隨機數字為:");
        for (int num : set) {
            System.out.print(num+", ");
        }
    }
}

