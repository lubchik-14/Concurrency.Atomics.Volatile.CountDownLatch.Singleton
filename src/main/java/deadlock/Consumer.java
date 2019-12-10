package deadlock;

public class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            int count = (int) (Math.random() * 100);
            if (store.storage < count) {
                try {
                    System.out.printf("Consumer needs : %s. Balance : %s\n Waiting ...\n",count, store.storage);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (store) {
                    store.take(count);
                }
                notifyAll();
            }
        }
    }
}
