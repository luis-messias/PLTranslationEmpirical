import java.util.Scanner;

public class s043174379 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read H and W from the first line
        String line1 = scanner.nextLine();
        String[] parts1 = line1.split(" ");
        int H = Integer.parseInt(parts1[0]);
        int W = Integer.parseInt(parts1[1]);

        // Read h and w from the second line
        String line2 = scanner.nextLine();
        String[] parts2 = line2.split(" ");
        int h = Integer.parseInt(parts2[0]);
        int w = Integer.parseInt(parts2[1]);

        // Calculate the result: ans = H * W - (h * W + w * H - h * w)
        int ans = H * W - (h * W + w * H - h * w);

        System.out.println(ans);
    }
}