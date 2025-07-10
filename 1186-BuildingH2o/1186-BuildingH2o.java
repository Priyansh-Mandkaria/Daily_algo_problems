// Last updated: 7/10/2025, 8:56:13 AM
import java.util.concurrent.Semaphore;

class H2O {
    private Semaphore hydrogenSemaphore = new Semaphore(2);
    private Semaphore oxygenSemaphore = new Semaphore(1);
    private final Object lock = new Object();
    private int hydrogenCount = 0;

    public H2O() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        synchronized (lock) {
            while (hydrogenCount == 2) {
                lock.wait();
            }
            releaseHydrogen.run();
            hydrogenCount++;
            if (hydrogenCount == 2) {
                oxygenSemaphore.release();
            }
            lock.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        synchronized (lock) {
            releaseOxygen.run();
            hydrogenCount = 0;
            hydrogenSemaphore.release(2);
            lock.notifyAll();
        }
    }
}
