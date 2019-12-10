package point;

import java.util.concurrent.CountDownLatch;

public class MoveMaker implements Runnable {
    private final CountDownLatch doneSignal;
    private final Point point;

    public MoveMaker(CountDownLatch doneSignal, Point point) {
        this.doneSignal = doneSignal;
        this.point = point;
    }

    @Override
    public void run() {
        point.move(1, 1);
        doneSignal.countDown();
    }
}
