package deadlock;

public class Producer implements Runnable {
    Store store;
    IProducerObserver observer;

    public Producer(IProducerObserver observer) {
        this.observer = observer;
    }

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                int count = (int) (Math.random() * 100);
                if (store.storage > 100) {
                    try {
                        observer.onWaiting(count, store.storage);
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (store) {
                    store.put(count);
                }
                notifyAll();
            }
        }
    }
}
