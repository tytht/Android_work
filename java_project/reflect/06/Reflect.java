//import a.b.c.d.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;	//为使用Method获取成员方法而引入的类

public class Reflect {
	public static void main(String args[]) throws Exception {
		Class<?> c = null;

		try {
			c = Class.forName("a.b.c.d.Person");
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
		Object p2 = con.newInstance("XiaoMing");

		Method set = c.getMethod("setName", String.class); //获得setName()方法
		set.invoke(p2, "123"); //调用对象p2的setName()方法
		set.invoke(p, "abc");

		Method get = c.getMethod("getName");

		System.out.println(get.invoke(p));
		System.out.println(get.invoke(p2));
		
	}
}

/*
$ javac -d . Person.java 
$ javac Reflect.java 
$ java Reflect
Constructor of Person
Constructor2 of Person, name is XiaoMing
abc
123

*/