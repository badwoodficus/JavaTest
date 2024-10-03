package xxx;

public class PolyAnimalTest {
	public static void main(String[] args) {
		Animal a[]= new Animal[3];
		a[0] = new Elephant("David",10,1200.0f);
		a[1] = new Animal(2,5.0f);
		a[2] = new Elephant("Lyn",4,700.0f);
		
		for(int i =0; i< a.length;i++) {
			a[i].speak();
			System.out.println("============");
		}
		
	}
}
