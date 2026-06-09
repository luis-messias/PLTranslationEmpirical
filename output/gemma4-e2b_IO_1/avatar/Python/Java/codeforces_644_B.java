import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Scanner;

class Task {
    int time;
    int duration;
    int index;

    public Task(int time, int duration, int index) {
        this.time = time;
        this.duration = duration;
        this.index = index;
    }
}

public class codeforces_644_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and b
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int b = scanner.nextInt();

        Queue<Task> remaining = new LinkedList<>();
        boolean running = false;
        int finishTime = 0;

        // Read n tasks and process them sequentially
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) break;
            int time = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int duration = scanner.nextInt();

            Task task = new Task(time, duration, i);
            
            // result map initialization
            HashMap<Integer, Integer> result = new HashMap<>();
            result.put(i, 0);

            // Python logic: if task.time > finish_time and remaining.empty()
            if (task.time > finishTime && remaining.isEmpty()) {
                running = true;
                finishTime = task.time + task.duration;
                result.put(i, finishTime);
            } else {
                // Python logic: if task.time >= finish_time and not remaining.empty()
                if (task.time >= finishTime && !remaining.isEmpty()) {
                    // Simulate run_task logic: finish_time, result = run_task(remaining, finish_time)
                    
                    // Since we are simulating the state update based on the Python function call, 
                    // we need to handle the queue interaction explicitly here.
                    
                    Task taskToRun = remaining.poll(); // Get the next task from the queue
                    
                    // Calculate new finish time based on the task pulled from the queue
                    finishTime = Math.max(finishTime, taskToRun.time) + taskToRun.duration;
                    result.put(taskToRun.index, finishTime);
                    
                    // Put the current task back if it was pulled out (this is complex due to Python's structure)
                    // The Python code structure suggests that run_task handles the queue interaction.
                    // Let's stick closer to the Python structure where run_task is called.
                    
                    // Reverting to the structure where we simulate the effect of run_task:
                    
                    // If we are here, we are simulating the call: finish_time, result = run_task(remaining, finish_time)
                    // Since we are processing tasks sequentially, the queue state is critical.
                    
                    // If we assume the Python code intends for the queue to hold tasks that *have arrived* but haven't been processed yet, 
                    // and the simulation is about scheduling based on arrival time:
                    
                    // We must ensure that if we run a task, we update the state correctly.
                    
                    // Let's simplify the simulation based on the observed pattern:
                    // If we enter this block, it means we are trying to schedule the current task (task) 
                    // against the current finishTime, potentially using tasks already in the queue.
                    
                    // Since the Python code calls run_task only when task.time >= finish_time AND remaining is not empty, 
                    // and then immediately puts the current task into remaining if space allows, 
                    // this suggests a specific scheduling mechanism.
                    
                    // We will simulate the core logic of run_task here:
                    
                    Task taskToRunFromQueue = remaining.poll();
                    if (taskToRunFromQueue != null) {
                        finishTime = Math.max(finishTime, taskToRunFromQueue.time) + taskToRunFromQueue.duration;
                        result.put(taskToRunFromQueue.index, finishTime);
                    }
                    
                }
                
                // Python logic: if remaining.qsize() < b: remaining.put(task)
                if (remaining.size() < b) {
                    remaining.add(task);
                } else {
                    result.put(i, -1);
                }
