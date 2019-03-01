/*InnerDemo3.java: Anonymous inner class*/

interface A {
	public void printInfo();
}

class B implements A {
	public void printInfo() {
		System.out.println("Hello, world!");
	}
}


public class InnerDemo3 {
	public static void main(String args[])	{
		testFunc(new B());
		testFunc(new A(){
			public void printInfo() {
				System.out.println("Hello, world2!");
				}
			});
	}

	public static void testFunc(A a) {
		a.printInfo();
	}
}

