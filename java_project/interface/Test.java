

interface AA{
    //常量 : 所有的常量都用public static finial修饰 默认的,写不写都有
    int I = 15;
//  public static final int I = 12;
//  public static final boolean FLAG = false;

    /*抽象方法 
     * 
     * 抽象方法:所有的都用public abstract 修饰
            写不写都有
     * */
    void method1();
    void method2();
//  public abstract void method1();
//  public abstract void method2();
    
}

abstract class Test1 implements AA{
// 	public static void main(String args[]) {
// //		Test t1 = new Test();

// //		t1.method1();
// //		t1.method2();
// 		method1();
// 	}

    public static void method1() {
    	System.out.println("method1");
    }
    // public void method2() {
    // 	System.out.println("method2");
    // }
}

public class Test implements Test1{
	public static void main(String args[]) {
		Test t1 = new Test();

		t1.method1();
		t1.method2();
	}

    public static void method2() {
    	System.out.println("method2");
    }
    // public void method2() {
    // 	System.out.println("method2");
    // }
}
