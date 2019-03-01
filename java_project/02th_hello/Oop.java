class Persion {
	String name;
	static int count;
	static String name_tmp;

	public Persion (String name) {
		System.out.println("Constructor fun of " + name);
		this.name = name;
		name_tmp = name;
	}

	{
		System.out.println("Code Block of " + name);
		count++;		
	}

	static {
		System.out.println("static Code Block of " + name_tmp);
	}

	public String getName() {
		return "Henan: "+name;
	}

	public void setName(String name) {
		this.name = name;
	}

};


public class Oop {
	public static void main(String args[]) {
		Persion p1 = new Persion("ZhangShan");
		Persion p2 = new Persion("LiShi");
		Persion p3 = new Persion("WangE");

		System.out.println(p1.getName());
		System.out.println(p2.getName());
		System.out.println(p3.getName());

		System.out.println("There are: "+Persion.count+" persions");
	}
};


/*
static Code Block of null	//Static code block call first, So null 
Code Block of null			//Code block call first, So null 
Constructor fun of ZhangShan
Code Block of null
Constructor fun of LiShi
Code Block of null
Constructor fun of WangE
Henan: ZhangShan
Henan: LiShi
Henan: WangE
There are: 3 persions
*/




