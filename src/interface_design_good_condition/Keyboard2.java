package interface_design_good_condition;

public class Keyboard2 implements USB {

	@Override
	public void work() {
		System.out.println("輸入文字");
	}
	
	
}
