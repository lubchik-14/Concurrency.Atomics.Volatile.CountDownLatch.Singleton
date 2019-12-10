package deadlock;

public interface IStoreObserver {
    void onPut(int count);
    void onTake(int count);
    void update(int balance);
}
