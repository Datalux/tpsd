public class Main{

	public static void main(String[] args){

		Gioco gioco = new Gioco();

		Thread t0 = new Thread(new T0(gioco));
		Thread t1 = new Thread(new T1(gioco));

		t0.start();
		t1.start();

		try{
			t0.join();
			t1.join();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}