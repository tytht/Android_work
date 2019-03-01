package a.b.c.d;

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
build1:
$ javac -d . Reflect.java 
$ java a.b.c.d.Reflect 
a.b.c.d.Person


build2:
$ javac a/b/c/d/Reflect.java 
$ java a.b.c.d.Reflect 
a.b.c.d.Person
*/


