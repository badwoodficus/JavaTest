package fubang;

import java.util.Arrays;

public class Processor {
	public Processor() {
		System.out.printf("Creating Processor ");

	}

	public void process(int i, int j) {
		System.out.printf("Processing two integers:%d, %d", i, j);

		}

	public void process(int[] ints) {
		System.out.println("Adding integer array:" + Arrays.toString(ints));
	}

	public void process(Object[] objs) {
		System.out.println("Adding object array:" + Arrays.toString(objs));
	}
}
