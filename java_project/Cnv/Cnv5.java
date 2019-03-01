/*Cnv5.java: Test Son=Father in printAction()*/

class Father {
	private int money;	

	public int getMoney() {return money; }
	public void setMoney(int money) {this.money = money; }

	public void printInfo() {System.out.println("This is Father");}
	public void drink() {System.out.println("drink ...");}

}

class Son extends Father{
	public void printInfo() {System.out.println("This is son");}
	public void playGame() {System.out.println("playGame ...");}
	
}

class Daughter extends Father{
	public void printInfo() {System.out.println("This is daughter");}
	public void dance() {System.out.println("dance ...");}

	
}

public class Cnv5 {
	public static void main (String args[]) {
		Father f = new Father();
		Son s = new Son();
		Daughter d = new Daughter();

		printAction(f);
		printAction(s);
		printAction(d);

		printAction_2(f);
		printAction_2(s);
		printAction_2(d);
	}

	public static void printAction(Father f) {  /*Son --> Father --> Son*/
		if (f instanceof Son) {
			Son son = (Son)f;
			son.playGame();
		}
		else if (f instanceof Daughter) {
			Daughter d = (Daughter)f;
			d.dance();
		}
		else if (f instanceof Father) {
			f.drink();
		}	
	}

	public static void printAction_2(Father f) {  /*Son --> Father --> Son*/
		if (f instanceof Father) {
			f.drink();
		}	
		else if (f instanceof Son) {
			Son son = (Son)f;
			son.playGame();
		}
		else if (f instanceof Daughter) {
			Daughter d = (Daughter)f;
			d.dance();
		}
	}
}

