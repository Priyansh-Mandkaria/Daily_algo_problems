// Last updated: 7/10/2025, 8:55:59 AM
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int current = 1;
    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private Semaphore numberSemaphore = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzSemaphore.acquire();
            if (current > n) break;
            printFizz.run();
            advance();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzzSemaphore.acquire();
            if (current > n) break;
            printBuzz.run();
            advance();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzBuzzSemaphore.acquire();
            if (current > n) break;
            printFizzBuzz.run();
            advance();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            numberSemaphore.acquire();
            if (current > n) break;
            printNumber.accept(current);
            advance();
        }
    }

    private synchronized void advance() {
        current++;
        if (current > n) {
            releaseAll();
            return;
        }
        if (current % 3 == 0 && current % 5 == 0) {
            fizzBuzzSemaphore.release();
        } else if (current % 3 == 0) {
            fizzSemaphore.release();
        } else if (current % 5 == 0) {
            buzzSemaphore.release();
        } else {
            numberSemaphore.release();
        }
    }

    private void releaseAll() {
        fizzSemaphore.release();
        buzzSemaphore.release();
        fizzBuzzSemaphore.release();
        numberSemaphore.release();
    }
}
