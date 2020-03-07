package parallel;

import java.util.concurrent.RecursiveAction;

/**
 * @author deepak.jayaprakash
 */
public class SumArray extends RecursiveAction {

    int THRESHOLD = 100; // control when you want to fork
    int low;
    int high;
    Integer sum = 0;
    Integer[] a;

    public SumArray(int low, int high, Integer[] a) {
        this.low = low;
        this.high = high;
        this.a = a;
    }

    @Override
    protected void compute() {
        if ((high - low) < THRESHOLD) {
            for (int i = low; i < high; i++) {
                sum += a[i];
            }
        } else {
            SumArray left = new SumArray(low, (high + low) / 2, a);
            SumArray right = new SumArray((high + low) / 2, high, a);
            left.fork();
            right.compute();
            left.join();
            sum = left.sum + right.sum;
        }
    }
}
