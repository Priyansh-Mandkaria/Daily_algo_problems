// Last updated: 7/10/2025, 8:56:12 AM
class FooBar {
    private int n;
    private boolean fooTurn = true;
    public FooBar(int n) {
        this.n = n;
    }
    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooTurn) {
                wait();
            }
            printFoo.run();
            fooTurn = false;
            notify(); 
        }
    }
    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (fooTurn) {
                wait();
            }
            printBar.run();
            fooTurn = true; 
            notify(); 
        }
    }
}
