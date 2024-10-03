package xxx;

public class Student {
	int score =80;
	public void play(int hours) {
		score -= hours;
	}
	public void study(int hours) {
		score += hours;
	}
	public static void main(String[] args) {
		Student Mika =new Student();
		Student Arthur = new Student();
		Mika.play(5);
		Arthur.study(4);
		System.out.print("Mika's score is "+Mika.score+"\n"+"Arthur's score is "+Arthur.score);
	}
}
