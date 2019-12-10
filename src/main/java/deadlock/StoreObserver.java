package deadlock;

public class StoreObserver implements IStoreObserver {
    @Override
    public void onPut(int count) {
        System.out.printf("%s was put to the Store\n", count);
    }

    @Override
    public void onTake(int count) {
        System.out.printf("%s was taken from the Store\n", count);
    }

    @Override
    public void update(int balance) {
        System.out.printf("Balance : %s\n", balance);
    }
}
