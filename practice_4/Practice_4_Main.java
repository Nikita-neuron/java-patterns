package practice_4;

public class Practice_4_Main {
    public static void main(String[] args) {
        ExecutorServiceTest executorServiceTest = new ExecutorServiceTest(1);
        executorServiceTest.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("We run it");
        });

        executorServiceTest.submit(() -> System.out.println("Start"));
        executorServiceTest.shutdown();
    }
}
