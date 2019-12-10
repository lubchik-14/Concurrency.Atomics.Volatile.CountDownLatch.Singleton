package helloworld;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HelloWorldMain {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        final Runnable helloPrinter = () -> System.out.print("Hello ");
        final Runnable worldPrinter = () -> System.out.print("World ");
        final Runnable enterPrinter = () -> System.out.print("!\n");

        ScheduledFuture<?> hello = scheduler.scheduleAtFixedRate(helloPrinter, 0, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> world = scheduler.scheduleAtFixedRate(worldPrinter, 0, 1, TimeUnit.SECONDS);
//        ScheduledFuture<?> enter = scheduler.scheduleAtFixedRate(enterPrinter, 1, 1, TimeUnit.SECONDS);

        scheduler.schedule(() -> hello.cancel(true), 60, TimeUnit.SECONDS);
        scheduler.schedule(() -> world.cancel(true), 60, TimeUnit.SECONDS);
//        scheduler.schedule(() -> enter.cancel(true), 60, TimeUnit.SECONDS);





    }
}
