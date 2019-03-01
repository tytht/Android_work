package a.b.c.d; //要把编译生成的class文件放在指定目录下的a/b/c/d/目录下

public class Pack {
	public static void main(String args[]) {
		System.out.println("Hello, world!");
	}
}

/*
$ javac -d . Pack.java
$ java a.b.c.d.Pack
*/