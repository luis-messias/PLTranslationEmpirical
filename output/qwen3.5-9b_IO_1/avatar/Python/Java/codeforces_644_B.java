import java.util.*;

public class codeforces_644_B {
    static class Task {
        int time;
        int duration;
        int index;
        
        public Task(int time, int duration, int index) {
            this.time = time;
            this.duration = duration;
            this.index = index;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        
        Queue<Task> remaining = new LinkedList<>();
        boolean running = false;
        int finishTime = 0;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int time = scanner.nextInt();
            int duration = scanner.nextInt();
            Task task = new Task(time, duration, i);
            result[i] = 0;
            
            if (task.time > finishTime && remaining.isEmpty()) {
                running = true;
                finishTime = task.time + task.duration;
                result[i] = finishTime;
            } else {
                if (task.time >= finishTime && !remaining.isEmpty()) {
                    finishTime = Math.max(finishTime, task.time) + task.duration;
                    result[task.index] = finishTime;
                }
                if (remaining.size() < b) {
                    remaining.add(task);
                } else {
                    result[i] = -1;
                }
            }
        }
        
        while (!remaining.isEmpty()) {
            Task task = remaining.poll();
            finishTime = Math.max(finishTime, task.time) + task.duration;
            result[task.index] = finishTime;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
