public class TD implements Runnable {

    Shared s;

    public TD(Shared s){
        this.s = s;
    }

    @Override
    public void run(){
        for(int i = 0; i < 1000; i++){
            try{
                Thread.sleep(300);
            } catch (Exception e){
                e.printStackTrace();
            }

            int val = (int)(Math.random()*10);

            if(!s.sottrai(val)) break;
        }
    }
}
