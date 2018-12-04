

public class Main {

    public static void main(String[] args){

        Shared shared = new Shared();

        Thread ti = new Thread(new TI(shared), "tI");
        Thread td = new Thread(new TD(shared), "tD");

        ti.start();
        td.start();


    }

}
