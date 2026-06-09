import java.util.Scanner;

public class codeforces_387_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read Time 1
        String time1Str = scanner.nextLine();
        
        // Parse Time 1
        String[] parts1 = time1Str.split(":");
        int h1 = Integer.parseInt(parts1[0]);
        int m1 = Integer.parseInt(parts1[1]);
        
        // Calculate total minutes for Time 1 (m1 now holds total minutes)
        int totalMinutes1 = h1 * 60 + m1;

        // Read Time 2
        String time2Str = scanner.nextLine();
        
        // Parse Time 2
        String[] parts2 = time2Str.split(":");
        int h2 = Integer.parseInt(parts2[0]);
        int m2 = Integer.parseInt(parts2[1]);
        
        // Calculate total minutes for Time 2 (m2 now holds total minutes)
        int totalMinutes2 = h2 * 60 + m2;

        // Calculate difference (m2 = m1 - m2)
        int differenceMinutes = totalMinutes1 - totalMinutes2;

        // Handle wrap around (modulo 1440). Ensure positive result.
        int resultMinutes = differenceMinutes % 1440;
        if (resultMinutes < 0) {
            resultMinutes += 1440;
        }

        // Calculate hours and remaining minutes
        int hours = resultMinutes / 60;
        int minutes = resultMinutes % 60;

        // Output formatting
        System.out.printf("%02d:%02d%n", hours, minutes);
    }
}