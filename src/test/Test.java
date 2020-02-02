package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		/*A b = new B();
		b.print();*/
		
		Test t = new Test();
		t.add(10, 10);
		t.add(10.35f, 10.35f);
		t.add(10.35f, 10);
	}
	
	public void test() throws Exception {
		double d = 4223;
		int i = (int) d;
		System.out.println(i);
		Map<Test, Object> map = new HashMap<Test, Object>();
		Test t = new Test();
		map.put(t, t);
		
		Class c = t.getClass();
		System.out.println(c.getCanonicalName());
		
		try {
			throw new Exception();
		}
		finally {
			System.out.println("Finally");
		}
	}
	
	public void add(int a, int b) {
		System.out.println("Both int");
	}
	
	public void add(float a, int b) {
		System.out.println("One float One int");
	}
	
	public void add(float a, float b) {
		System.out.println("Both float");
	}

}
