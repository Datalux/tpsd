public class Shared{
	int m;

	public Shared(){
		m = (int)(Math.random()*10)+1;
	}

	synchronized public void setValue(int value){
		m = value;
		notifyAll();
	}

	synchronized public int getValue(){
		return m;
	}
}