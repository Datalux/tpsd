public class TI implements Runnable {

    Shared s;

    public TI(Shared s){
        this.s = s;
    }



    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            try{
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            }

            int val = (int)(Math.random() * 10);

            if(!s.somma(val)) break;

        }




    }
}
