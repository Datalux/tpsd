public class Shared{
	private int x;

	Shared(){
		this.x = 0;
	}

	synchronized public int getValue(){
		return x;
	}

	synchronized public void increase(){
		x++;
	}
}