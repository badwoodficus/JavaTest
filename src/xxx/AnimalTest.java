package xxx;

public class AnimalTest extends Elephant {
	public static void main(String[] args) {
		Animal cat = new Animal(3,8.0f);
		cat.speak();
		Elephant elephant = new Elephant();
		System.out.println();
		elephant.speak();
	}
}
