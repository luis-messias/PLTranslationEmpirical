import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
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

        // The Python code reads task data inside the loop, which seems to imply reading n tasks sequentially.
        // We need to read n pairs of time and duration.
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) break;
            int time = scanner.nextInt();
            if (!scanner.hasNextInt()) break;
            int duration = scanner.nextInt();

            Task task = new Task(time, duration, i);
            
            // result map initialization (Python used result.update({i: 0}))
            Map<Integer, Integer> result = new HashMap<>();
            result.put(i, 0);

            if (task.time > finishTime && remaining.isEmpty()) {
                running = true;
                finishTime = task.time + task.duration;
                result.put(i, finishTime);
            } else {
                if (task.time >= finishTime && !remaining.isEmpty()) {
                    // Simulate run_task logic
                    // Note: Since we are reading tasks sequentially, the queue might be empty or contain tasks read earlier.
                    // We must simulate the state update based on the Python logic.
                    
                    // In the Python code, run_task modifies finish_time and result.
                    // We need to handle the queue interaction carefully.
                    
                    // Since the Python code calls run_task only when task.time >= finish_time AND remaining is not empty, 
                    // and then immediately puts the current task into remaining if space allows, 
                    // this structure suggests a complex interaction between reading input and queue management.
                    
                    // For a direct translation, we simulate the call:
                    
                    // We need to ensure 'remaining' queue is populated correctly before calling run_task.
                    // Since the Python code structure is highly dependent on the state of 'remaining' queue