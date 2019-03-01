public class Hello {
    private String name;	/*C程序中调用SetObjectField()来设置*/
    private int age;		/*C程序中调用SetIntField()来设置*/
    
	public static void main(String args[]) {
		System.out.println("Hello, world!");
	}

    public int sayhello_to(String name) {
		System.out.println("Hello, "+name+"! I am "+this.name+", "+age+" years old.");       
        return 123;
    }

    public static void sayhello_to() {
    }
}