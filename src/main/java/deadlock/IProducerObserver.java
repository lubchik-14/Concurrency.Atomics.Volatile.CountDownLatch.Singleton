package deadlock;

public interface IProducerObserver {
    void onWaiting(int count, int balance);
    void onReady(int count, int balance);
}
