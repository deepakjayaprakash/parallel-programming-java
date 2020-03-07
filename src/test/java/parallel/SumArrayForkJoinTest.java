package parallel;

import org.junit.Test;

/**
 * @author deepak.jayaprakash
 */
public class SumArrayForkJoinTest {

    public Integer[] generateArray() {
        Integer a[] = new Integer[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = i;
        }
        return a;
    }

    @Test
    public void compareSequentialVsParallel() {
        SumArrayForkJoin sumArrayForkJoin = new SumArrayForkJoin();
        sumArrayForkJoin.a = generateArray();
        sumArrayForkJoin.sequentialSum();
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
        sumArrayForkJoin.parallelSum();
    }
}
