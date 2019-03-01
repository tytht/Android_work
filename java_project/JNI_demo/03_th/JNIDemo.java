public class JNIDemo {

	static { // 1. load
		System.loadLibrary("native");
 	}

	public native int hello(int[] arr); //still is int in java, but jint in C

	public static void main(String args[]) {
		JNIDemo d = new JNIDemo();

		int[] arr = {1, 2, 3};

		System.out.println(d.hello(arr));
	}
	
}

/*
public class JNIDemo {

	static { // 1. load
		System.loadLibrary("native");
 	}

	public native static int hello(int a); //still is int in java, but jint in C

	public static void main(String args[]) {
		System.out.println(hello(111));
	}
	
}
*/






