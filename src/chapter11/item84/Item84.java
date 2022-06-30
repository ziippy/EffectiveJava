package chapter11.item84;

// 이런 식으로 바쁜 대기 버전을 만들지 말라.
class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized (this) {
                if (count == 0)
                    return;
            }
        }
    }

    public synchronized void countDown() {
        if (count != 0) {
            count--;
        }
    }
}

public class Item84 {

    public static void main(String[] args) throws InterruptedException {

    }

}

