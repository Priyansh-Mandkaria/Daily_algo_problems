// Last updated: 7/10/2025, 8:55:54 AM
public class DiningPhilosophers {
    private final ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        Arrays.fill(forks, new ReentrantLock());
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        var forksRequired = new ArrayList<>(List.of(philosopher, (philosopher + 1) % 5));
        forksRequired.sort(Integer::compareTo);
        var firstFork = forksRequired.get(0);
        var secondFork = forksRequired.get(1);
        System.out.println(Thread.currentThread().getName() + " wants to eat");
        while (true) { //philosopher should eat and think alternatively.
            if (forks[firstFork].tryLock(1, TimeUnit.MILLISECONDS)) {
                if (forks[secondFork].tryLock(1, TimeUnit.MILLISECONDS)) { //wait is required to avoid deadlock
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putRightFork.run();
                    putLeftFork.run();
                    System.out.println(Thread.currentThread().getName() + " finished eating");
                    forks[secondFork].unlock();
                    forks[firstFork].unlock();
                    break;
                } else {
                    forks[firstFork].unlock();
                }
            }
        }
    }
}