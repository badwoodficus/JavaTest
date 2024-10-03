package fubang;

public class Demo {
	public static void main(String[] args) {
		Processor processor = new MathProcessor();
		processor.process(2, 3);
		processor.process(new Object[] { 2, 3 });
		processor.process(new int[] { 2, 3 });
	}
}
