package deadlock;

import java.util.concurrent.*;

public class DeadlockMain {
    public static void main(String[] args) {
        Store store = new Store(new StoreObserver());
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        Thread cons = new Thread(new Consumer(store));
        Thread prod = new Thread(new Producer(store));
        cons.start();
        prod.start();

//        ScheduledFuture<?> consumer = service.schedule(new Consumer(store), 0, 1, TimeUnit.MILLISECONDS);
    }
}
