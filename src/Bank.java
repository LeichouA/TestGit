import java.util.Arrays;

public class Bank {

    private final double[] accouts;

    public  Bank(int n, double initialBalance){

        accouts = new double[n];
        Arrays.fill(accouts,initialBalance);
    }

    public void transfer(int from, int to, double amount){

        if (accouts[from] <amount) return;
        System.out.println(Thread.currentThread());
        accouts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount,from,to);
        accouts[to] += amount;
        System.out.printf("Total Balance: %10.2f%n",getTotalBalance());

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
