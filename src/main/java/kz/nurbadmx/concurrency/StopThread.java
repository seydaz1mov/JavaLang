package kz.nurbadmx.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    private synchronized void requestStop() {
        stopRequested = true;
    }

    private synchronized boolean stopRequested() {
        return stopRequested;
    }

    public void start() throws InterruptedException {
        System.out.println("Start PROCESS");
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested())
                    i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        requestStop();
        System.out.println("Finish PROCESS");
    }
}
