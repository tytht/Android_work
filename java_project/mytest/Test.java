public class Ext {
	public static void main (String args[]) {
		int b = 0;
		test(b);
		System.out.println(b);
	}


	public static void test(int& a) {
		a = 123456;
	}
}