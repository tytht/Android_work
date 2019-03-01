public class JNIDemo {

	static { // 1. load
		System.loadLibrary("native");
 	}

	public native int hello(int a); //still is int in java, but jint in C

	public static void main(String args[]) {
		JNIDemo d = new JNIDemo();

		System.out.println(d.hello(111));
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






