

/* java Div 6 2
 * 6/2=3
 */

public class Div1 {

	public static void main(String args[]) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int r = 0;

		System.out.println("Begin of div");
		try {
			r = div(m, n);			
		} catch (ArithmeticException e) {
			System.out.println("Div: "+e);
		}

		System.out.println("End of div");

		System.out.println(m+"/"+n+"="+r);
		
	}

	public static int div(int m, int n) {
		int r = m / n;
		return r;
	}
}

