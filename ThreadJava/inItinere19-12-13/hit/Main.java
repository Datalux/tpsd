public class Main{
	public static void main(String[] args){

		Shared shared = new Shared();

		Thread tA = new Thread(new tA(shared));
		Thread tB = new Thread(new tB(shared));

		tA.start();
		tB.start();

		try{
			tA.join();
			tB.join();
		} catch(Exception e) {}

		System.out.println("All threads end correctly");
	}
}