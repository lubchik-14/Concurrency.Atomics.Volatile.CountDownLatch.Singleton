package deadlock;

public class ProducerObserver implements IProducerObserver {
    @Override
    public void onWaiting(int count, int balance) {
        System.out.printf("Producer has : %s. Balance : %s\n Waiting ...\n",count, balance);
    }

    @Override
    public void onReady(int count, int balance) {
        System.out.printf("Producer is ready to produce : %s. Balance : %s\n",count, balance);
    }
}
