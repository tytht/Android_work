class Father {
	private int money;	

	public int getMoney() {return money; }
	public void setMoney(int money) {this.money = money; }

	public void printInfo() {System.out.println("This is Father's printInfo");}

	private void printInfo2() {System.out.println("This is Father's printInfo2");}
}

class Son extends Father{
	public void printInfo() {System.out.println("This is son's printInfo");}

	public void printInfo2() {System.out.println("This is son's printInfo2");}
	
}

public class Ext5 {
	public static void main (String args[]) {
		Son son = new Son();
		son.setMoney(100);
		son.printInfo();
		son.printInfo2();
	}
}

