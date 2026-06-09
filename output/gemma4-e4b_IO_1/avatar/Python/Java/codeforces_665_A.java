import java.util.Scanner;

public class codeforces_665_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a and at
        int a = scanner.nextInt();
        int at = scanner.nextInt();

        // Read b and bt
        int b = scanner.nextInt();
        int bt = scanner.nextInt();

        // Consume the rest of the line after reading b and bt
        scanner.nextLine(); 

        // Read the time string t1:t2
        String timeLine = scanner.nextLine();
        
        String[] timeParts = timeLine.split(":");
        int t1 = Integer.parseInt(timeParts[0]);
        int t2 = Integer.parseInt(timeParts[1]);

        // Calculate start time (st) and finish time (fin) in minutes
        int st = t2 + (t1 - 5) * 60;
        int fin = st + at;

        // Simulation variables
        int now = 0;
        int ans = 0;

        // Loop condition: while now < fin AND now < 1140
        while (now < fin && now < 1140) {
            // Check for overlap: if the end time (now + bt) is past the start time (st)
            if (now + bt > st) {
                ans += 1;
            }
            now += b;
        }

        System.out.println(ans);
    }
}
