
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Lesson25 {
    static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        //1, 2
        CountDownLatch latch2000 = new CountDownLatch(2000);

        for (int i = 0; i < 2000; i++) {
            service.submit(new Counter(latch2000));
        }
        try {
            latch2000.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count : " + count);

        //3
        CountDownLatch latch1 = new CountDownLatch(1);
        for (int i = 0; i < 2000; i++) {
            service.submit(MySingleton::getInstance);
        }
        latch1.countDown();

        try {
            latch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Were created " + MySingleton.instanceCount + " instances of MySingleton");

        service.shutdown();
    }
}
