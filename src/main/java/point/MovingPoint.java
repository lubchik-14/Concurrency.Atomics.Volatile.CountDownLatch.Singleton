package point;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MovingPoint {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Point myPoint = new Point();
        myPoint.addObserver(new PointConsoleObserver());
        CountDownLatch doneSignal = new CountDownLatch(2000);
        for (int i = 0; i < 2000; i++) {
            service.execute(new MoveMaker(doneSignal, myPoint));
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred awaiting done signal");
        }
        System.out.printf("Point[%s:%s]\n", myPoint.getX(), myPoint.getY());
        service.shutdown();
    }
}
