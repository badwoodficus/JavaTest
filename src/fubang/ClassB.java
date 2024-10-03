package fubang;

public class ClassB extends ClassA{
	public void methodA() {
//		System.out.println(this.a);  a是private只有該類別內可以使用
		System.out.println(this.b);
		System.out.println(this.c);
		System.out.println(this.d);
	}
}
