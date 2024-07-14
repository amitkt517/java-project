import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadingExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit tasks to the executor service using Lambda Expressions
        for (int i = 1; i <= 8; i++) {
            int taskNumber = i;
            executorService.submit(() -> {
                System.out.println("Executing task " + taskNumber + " on thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskNumber + " completed on thread " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor service
        executorService.shutdown();
    }
}
