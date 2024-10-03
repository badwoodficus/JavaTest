package xxx;

public class Test {
	public static void main(String[] args) {
		Weightable [] wt= new Weightable[3];
		wt[0] = new Plane();
		wt[1]= new Powder();
		wt[2] = new Dog();
		
		for(int i =0 ;i<wt.length ;i++) {
			wt[i].printWeightTool();
		}
	}
}
