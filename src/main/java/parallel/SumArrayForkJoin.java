package parallel;

import java.util.concurrent.ForkJoinPool;

/**
 * @author deepak.jayaprakash
 */
public class SumArrayForkJoin {
    Integer a[];

    public void sequentialSum() {
        long startTime = System.nanoTime();
        Integer sum = 0;
        for (Integer i : a) {
            sum += i;
        }
        long end = System.nanoTime();
        System.out.println("sequential sum = " + sum + " time = " + (end - startTime));
    }

    public void parallelSum() {
        long startTime = System.nanoTime();
        SumArray sumArray = new SumArray(0, a.length, a);
        ForkJoinPool.commonPool().invoke(sumArray);
        long end = System.nanoTime();
        System.out.println("parallel sum = " + sumArray.sum + " time = " + (end - startTime));
    }
}
