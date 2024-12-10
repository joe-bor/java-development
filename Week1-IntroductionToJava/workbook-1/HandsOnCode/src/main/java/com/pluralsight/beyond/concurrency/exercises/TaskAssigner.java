package com.pluralsight.beyond.concurrency.exercises;

import java.util.concurrent.*;

public class TaskAssigner {

    public static void main(String[] args) {

        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            Runnable task1 = () -> {
                long start = System.currentTimeMillis();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long elapsed = System.currentTimeMillis() - start;
                System.out.printf("Task 1 completed in %d ms (Thread ID: %d, Thread Name: %s)%n \n",
                        elapsed, Thread.currentThread().threadId(), Thread.currentThread().getName());
            };

            Callable<Task> task2 = () -> {
                long start = System.currentTimeMillis();
                Thread.sleep(1500);
                long elapsed = System.currentTimeMillis() - start;

                System.out.printf("Task 2 completed in %d ms (Thread ID: %d, Thread Name: %s)%n \n",
                        elapsed, Thread.currentThread().threadId(), Thread.currentThread().getName());

                return new Task("Task #2");
            };

            // Submit tasks
            Future<?> future1 = executorService.submit(task1);
            Future<Task> future2 = executorService.submit(task2);

            Task task = future2.get();
            System.out.println("Result of Task 2: " + task);

            future1.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Task {
        private final String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public String toString() {
            return "Task: %s".formatted(taskName);
        }
    }
}
