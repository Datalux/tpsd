public class tA implements Runnable{
	Shared x;
	int hit;

	public tA(Shared s){
		this.x = s;
		hit = 0;
	}

	@Override
	public void run(){
		while(true){
			int time = (int)(Math.random()*10) +1;
			try{
				Thread.sleep(time);
			} catch (Exception e) {}
			if(x.getValue() > 500){
				System.out.printf("[tA] hit = %d\n",hit);
				break;
			} else {
				x.increase();
				System.out.println("[tA] x = " + x.getValue());
				hit++;
			}
		}
	}
}