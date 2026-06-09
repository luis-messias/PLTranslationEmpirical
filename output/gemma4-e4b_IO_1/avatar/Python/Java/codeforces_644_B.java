import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

class Task {
    long time;
    long duration;
    int index;

    public Task(long time, long duration, int index) {
        this.time = time;
        this.duration = duration;
        this.index = index;
    }
}

public class codeforces_644_B {

    /**
     * Runs the next task from the queue and updates the finish time and results.
     * @param remaining The queue of remaining tasks.
     * @param finishTime The current finish time.
     * @param result The array storing the final finish times.
     * @return The new finish time.
     */
    private static long runTask(Queue<Task> remaining, long finishTime, long[] result) {
        if (remaining.isEmpty()) {
            // Should not happen if called correctly, but defensive check
            return finishTime;
        }
        
        Task taskToRun = remaining.poll();
        
        // finish_time = max(finish_time, task_to_run.time) + task_to_run.duration
        long newFinishTime = Math.max(finishTime, taskToRun.time) + taskToRun.duration;
        
        result[taskToRun.index] = newFinishTime;
        
        return newFinishTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and B
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int b = scanner.nextInt();

        // Initialize state variables
        Queue<Task> remaining = new LinkedList<>();
        boolean running = false;
        long finishTime = 0;
        
        // result array stores the finish time for each task index
        long[] result = new long[n];
        Arrays.fill(result, 0);

        // Process tasks sequentially
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLong()) break;
            long time = scanner.nextLong();
            long duration = scanner.nextLong();

            Task task = new Task(time, duration, i);

            // Initialize result[i] to 0 (as per Python logic)
            result[i] = 0;

            // Python logic check: if task.time > finish_time and remaining.empty()
            if (task.time > finishTime && remaining.isEmpty()) {
                running = true;
                finishTime = task.time + task.duration;
                result[i] = finishTime;
            } else {
                // Python logic check: if task.time >= finish_time and not remaining.empty()
                if (task.time >= finishTime && !remaining.isEmpty()) {
                    // Run task and update finishTime and result
                    finishTime = runTask(remaining, finishTime, result);
                }
                
                // Queue management
                if (remaining.size() < b) {
                    remaining.offer(task);
                } else {
                    // Queue is full
                    result[i] = -1;
                }
            }
        }
        
        // Process remaining tasks in the queue
        while (!remaining.isEmpty()) {
            // runTask updates finishTime and result array
            finishTime = runTask(remaining, finishTime, result);
        }

        // Output results (space separated)
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
