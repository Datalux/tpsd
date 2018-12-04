public class tB implements Runnable{
	Shared x;
	int hit;

	public tB(Shared s){
		this.x = s;
		hit = 0;
	}

	@Override
	public void run(){
		while(true){
			int time = (int)(Math.random()*10)+1;
			try{
				Thread.sleep(time);
			} catch(Exception e) {}
			if(x.getValue() > 500){
				System.out.printf("[tB] hit = %d\n", hit);
				break;
			} else {
				x.increase();
				System.out.println("[tB] x = " + x.getValue());
				hit++;
			}
		}
	}
}