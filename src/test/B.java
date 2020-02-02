package test;

public class B extends A implements I {
	
	private String value = "B";
	
	private static String VALUE = "BB";
	
	public B() {
		System.out.println("Created B");
	}
	
	@Override
	public void print() {
		System.out.println("Print: " + VALUE);
		
	}
	
	@Override
	public B insatance() {
		return new B();
	}
	
	@Override
	public void finalize(){
		
	}
	
	public static void main(String[] args) {
		B b = new B();
		A a = b;
		I i = b;
		b.print();
		a.print();
		i.print();
		b.finalize();
	}

}
