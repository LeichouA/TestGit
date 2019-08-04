import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accouts;

    private Lock bankLock = new ReentrantLock();

    public  Bank(int n, double initialBalance){

        accouts = new double[n];
        Arrays.fill(accouts,initialBalance);
    }

    public void transfer(int from, int to, double amount){

        bankLock.lock();

        try {

            if (accouts[from] <amount) return;
            System.out.println(Thread.currentThread());
            accouts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount,from,to);
            accouts[to] += amount;
            System.out.printf("Total Balance: %10.2f%n",getTotalBalance());
        }finally {

            bankLock.unlock();
        }


    }

    public double getTotalBalance(){


        double sum = 0;
        for (double a: accouts)
            sum += a;
        return sum;
    }

    public int size(){
        return accouts.length;
    }

}
