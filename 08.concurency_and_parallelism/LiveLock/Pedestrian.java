package LiveLock;

public class Pedestrian {
    private Pedestrian other;
    private boolean isOnTheLeft;

    Pedestrian(boolean walkingLeft) {
        this.isOnTheLeft = walkingLeft;
    }

    void setOther(Pedestrian otherP) {
        this.other = otherP;
    }

    void switchDirection() throws InterruptedException {
        Thread.sleep(100);
        this.isOnTheLeft = !this.isOnTheLeft;
        System.out.println(Thread.currentThread().getName() + " is stepping aside.");
    }

    public void run() {
        while (this.isOnTheLeft == this.other.isOnTheLeft) {
            try {
                switchDirection();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is able to pass.");
    }

    public static void main(String[] args) {
        Pedestrian pedestrian1 = new Pedestrian(true);
        Pedestrian pedestrian2 = new Pedestrian(true);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                pedestrian1.setOther(pedestrian2);
                pedestrian1.run();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                pedestrian2.setOther(pedestrian1);
                pedestrian2.run();
            }
        };
        thread1.start();
        thread2.start();
    }
}