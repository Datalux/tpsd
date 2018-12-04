public class P2 implements Runnable{
	Shared m;
	
	public P2(Shared s){
		m = s;
	}

	@Override
	public void run(){
		while(true){
			if(m.getValue() >= 6){
				int v = (int)(Math.random()*10)+1;
				m.setValue(v);
				System.out.println("[P2] m = " + m.getValue());
			} else {
				try{
					wait();
				} catch(Exception e) {}
			}
		}
	}
}