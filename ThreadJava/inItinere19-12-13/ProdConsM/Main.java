public class Main{
	public static void main(String[] args){
		Shared m = new Shared();

		Thread p1 = new Thread(new P1(m));
		Thread p2 = new Thread(new P2(m));

		p1.start();
		p2.start();
	}

}