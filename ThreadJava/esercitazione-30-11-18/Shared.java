public class Shared {
    int n;

    Shared(){
        n = 100;
    }

    public synchronized boolean somma(int val){
        String threadName = Thread.currentThread().getName();
        n += val;
        System.out.printf("%s: %d\n", threadName, n);
        if(n > 150){
            System.out.printf("END %s\n", threadName);
            return false;
        }
        return true;
    }

    public synchronized boolean sottrai(int val){
        String threadName = Thread.currentThread().getName();
        n -= val;
        System.out.printf("%s: %d\n", threadName, n);
        if(n < 80){
            System.out.printf("END %s\n", threadName);
            return false;
        }
        return true;
    }
}
