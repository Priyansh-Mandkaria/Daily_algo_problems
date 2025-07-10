// Last updated: 7/10/2025, 8:56:08 AM
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int state = 0; 
    private int current = 1; 
    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                wait(); 
            }
            printNumber.accept(0);
            state = (current % 2 == 0) ? 2 : 1;
            notifyAll(); 
        }
    }
    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                wait();
            }
            printNumber.accept(current);
            current++; 
            state = 0; 
            notifyAll();
        }
    }
    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                wait();
            }
            printNumber.accept(current);
            current++;
            state = 0; 
            notifyAll(); 
        }
    }
}
