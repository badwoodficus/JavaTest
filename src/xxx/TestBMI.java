package xxx;

public class TestBMI {
	public static double CalBMI(double height,double weight) {
		return  (weight / (height * height));
	}
		
	public static void main(String[] args) {
		double height = 180 / 100d;
		double weight = 110;
		double bmi = CalBMI(height,weight);
//		double bmi =  weight / (height * height);
		
//		Math.pow(height, 2)也可以表示身高平方
		System.out.println("Your BMI is "+ bmi);
		System.out.printf("BMI =%.2f%n" , bmi); 
//		內建小數表示方法 f 與 %(表示該方法專用作區別).2f 小數點後兩位
//		%n為換行
		
		if(bmi < 18.5){
			System.out.print("過輕");
		}else if (bmi < 24) {
			System.out.print("正常");
		}else {
			System.out.print("過胖");
		}
	}
}
