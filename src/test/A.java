package test;

import java.io.Serializable;

public class A implements I, Serializable {

	private String value = "A";
	
	private static String VALUE = "AA";
	
	public A() {
		System.out.println("Created A");
	}
	
	@Override
	public void print() {
		System.out.println("Print: " + VALUE);
		
	}
	
	public A insatance() {
		return new A();
	}

}
