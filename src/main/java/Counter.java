import java.util.concurrent.CountDownLatch;

public class Counter implements Runnable {
    private final CountDownLatch latch;

    public Counter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        Lesson25.count.getAndIncrement();
        latch.countDown();
    }
}
