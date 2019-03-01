
import a.b.c.d1.*; //a.b.c.d1.Math
import a.b.c.d2.*; //若这里都直接写a.b.c.d2.Math会报错：Math already defined in a single-type import


public class Pack {
	public static void main(String args[]) {
		/* add */
		System.out.println(a.b.c.d1.Math.add(1,2)); //调用指定包的函数
		System.out.println(a.b.c.d2.Math.add(1,2));

		/* sub */
		System.out.println(a.b.c.d2.Math.sub(1,2));

		a.b.c.d2.Print.printInfo(); //调用包下面的Print类的printInfo方法
		Print.printInfo(); //也可以这样调用，如果没有同名的类的话就不需要使用包来限制它
	}
}


/*
javac -d . lisi/Math.java
javac -d . zhangsan/Math.java
javac -d . zhangsan/Print.java

javac Pack.java
javac Pack

*/




