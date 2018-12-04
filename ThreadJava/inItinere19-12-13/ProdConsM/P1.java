public class P1 implements Runnable{
	Shared m;
	
	public P1(Shared s){
		m = s;
	}

	@Override
	public void run(){
		while(true){
			if(m.getValue() <= 5){
				int v = (int)(Math.random()*10)+1;
				m.setValue(v);
				System.out.println("[P1] m = " + m.getValue());
			} else {
				try{
					wait();
				} catch(Exception e) {}
			}
		}
	}

}