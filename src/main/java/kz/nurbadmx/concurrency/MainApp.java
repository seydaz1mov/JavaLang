package kz.nurbadmx.concurrency;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread = new StopThread();
        stopThread.start();
    }
}
