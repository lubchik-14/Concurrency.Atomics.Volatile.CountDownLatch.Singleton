package deadlock;

public class Store {
    int storage;
    IStoreObserver observer;

    public Store(IStoreObserver observer) {
        this.observer = observer;
    }

    public void put(int count) {
        storage += count;
        observer.onPut(count);
        observer.update(storage);
    }

    public void take(int count) {
        storage -= count;
        observer.onTake(count);
        observer.update(storage);
    }
}
