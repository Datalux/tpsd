public class Gioco{
	private int pos = 0;
	private int vittorieT1 = 0;
	private int vittorieT2 = 0;
	final int MAX_WIN = 2;

	public Gioco(){ }

	synchronized public void decrementaPos(int value){
		if(pos >= 10){
			vittorieT1++;
			System.out.println("\nT1 WIN!\n");
			pos = 0;
			notifyAll();
		} else {
			pos -= value;
			System.out.printf("pos = %d\n", pos);
			if(pos <= -10){
				vittorieT2++;
				try{
					wait();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}


	synchronized public void incrementaPos(int value){
		if(pos <= -10){
			vittorieT1++;
			System.out.println("\nT2 WIN!\n");
			pos = 0;
			notifyAll();
		} else {
			pos += value;
			System.out.printf("pos = %d\n", pos);
			if(pos >= 10){
				vittorieT2++;
				try{
					wait();
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}


	synchronized public boolean isFinita(){
		return ((vittorieT1 == MAX_WIN) ||
				(vittorieT2 == MAX_WIN));
	}
}