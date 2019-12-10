public class MySingleton {
    private static Object lock = new Object();
    private static MySingleton instance;
    public static int instanceCount = 0;

    private MySingleton() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        instanceCount++;
    }

    public static MySingleton getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new MySingleton();
            }
        }
        return instance;
    }
}
