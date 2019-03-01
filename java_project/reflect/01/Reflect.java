//package a.b.c.d;

class Person {
	private String name;

	void setName(String name) { this.name = name; }
	String getName() { return this.name; }
	
};

public class Reflect {
	public static void main(String args[]) {
		Person p = new Person();

		p.setName("Sunfaliang");

		System.out.println(p.getClass().getName());
	}
}


/*
print Persion, why ?

call p.setName("Sunfaliang");, still is persion, why ???

$ javac Reflect.java 
$ ls
Person.class  Reflect.class  Reflect.java  // more one Person.class ??

*/


