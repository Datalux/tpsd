public class T1 implements Runnable{
	Gioco gioco;

	public T1(Gioco gioco){
		this.gioco = gioco;
	}

	@Override
	public void run(){
		while(!gioco.isFinita()){
			int recupero = (int)(Math.random() * 4);
			int forza = (int)(Math.random() * 6);
			try{
				Thread.sleep(recupero*1000L);
			} catch(Exception e) {
				e.printStackTrace();
			}
			gioco.decrementaPos(forza);
		}
	}
}