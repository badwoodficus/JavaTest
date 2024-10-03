package xxx;

public class Elephant extends Animal {
	private String name;

	public Elephant(String name, int age, float weight) {
		super(age, weight);
		this.name = name;
	}

	public Elephant() {
	}
//	speak內這樣寫的話父類別Animal沒有 name的參數
//	不符合Override的規則(參數不同)，所以執行Elephant speak時
//	會去執行Animal的 speak();不會印出name
//	public void speak(String name, int age, float weight) { 
//	super.speak();
//	System.out.println("名字: " + name);
//	}
	public void speak(){
		super.speak();
		System.out.println("名字: " + name);
	}
}
