import java.util.Queue;
import java.util.LinkedList;

public class codeforces_644_B {
    public static void main(String[] args) {
        import java.util.Scanner;
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        Queue<Task> remaining = new LinkedList<>();
        boolean running = false;
        int finishTime = 0;

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split(" ");
            int time = Integer.parseInt(input[0]);
            int duration = Integer.parseInt(input[1]);
            tasks[i] = new Task(time, duration, i);
        }

        for (Task task : tasks) {
            if (!running && task.getTime() > finishTime && remaining.isEmpty()) {
                running = true;
                finishTime = task.getTime() + task.getDuration();
                task.setResult(finishTime);
            } else if (task.getTime() >= finishTime && !remaining.isEmpty()) {
                finishTime = runTask(remaining, finishTime, tasks);
            }
            if (remaining.size() < b) {
                remaining.add(task);
            } else {
                task.setResult(-1);
            }
        }

        while (!remaining.isEmpty()) {
            finishTime = runTask(remaining, finishTime, tasks);
        }

        for (Task task : tasks) {
            System.out.println(task.getResult());
        }
    }

    public static int runTask(Queue<Task> remaining, int finishTime, Task[] tasks) {
        Task taskToRun = remaining.poll();
        finishTime = Math.max(finishTime, taskToRun.getTime()) + taskToRun.getDuration();
        for (Task task : tasks) {
            if (task.getIndex() == taskToRun.getIndex()) {
                task.setResult(finishTime);
            }
        }
        return finishTime;
    }

    static class Task {
        private int time;
        private int duration;
        private int index;

        public Task(int time, int duration, int index) {
            this.time = time;
            this.duration = duration;
            this.index = index;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        private int result;
    }
}
