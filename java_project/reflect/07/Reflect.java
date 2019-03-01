//import a.b.c.d.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Reflect {
	public static void main(String args[]) throws Exception {
		Class<?> c = null;

		try {
			c = Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		Object p = null;

		try {
			p = c.newInstance();
		} catch (InstantiationException e) {
			System.out.println(e);
		}

		Constructor<?> con = c.getConstructor(String.class);
		Object p2 = con.newInstance("weidongshan");

		Method set = c.getMethod("setName", String.class);
		set.invoke(p2, "123");
		set.invoke(p, "abc");

		Method get = c.getMethod("getName");

		System.out.println(get.invoke(p));
		System.out.println(get.invoke(p2));

		Field name = c.getDeclaredField("name");

		//name.setAccessible(true);

		name.set(p, "www");
		name.set(p2, "100ask");
		System.out.println(name.get(p));
		System.out.println(name.get(p2));
		
	}
}


/*
$ javac -d . Person.java 
$ javac -d . Student.java 
$ javac Reflect.java 
$ java Reflect a.b.c.d.Person
Constructor of Person
Constructor2 of Person, name is weidongshan
abc
123
www
100ask
$ 
$ java Reflect a.b.c.d.Student
Constructor of Student
Constructor2 of Student, name is weidongshan
abc
123
www
100ask
$
*/
