package chapter11.item78;


import java.util.EmptyStackException;
import java.util.concurrent.TimeUnit;

public class Item78 {

    private static boolean stopRequested = false;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    private static volatile boolean stopRequest2 = false;

    public static void main(String[] args) throws InterruptedException {
        // 잘못된 코드
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while(stopRequested) {      // stopRequest 값을 언제쯤에나 보게 될 지 보증할 수 없다.
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;


        // 적절히 동기화돼 스레드가 정상 종료 - 쓰기 메서드와 읽기 메서드 모두를 동기화했음
        Thread backgroundThread2 = new Thread(() -> {
            int i = 0;
            while(isStopRequested()) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

}

