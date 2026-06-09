import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC104_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read D and G
        if (!scanner.hasNextInt()) return;
        int D = scanner.nextInt();
        if (!scanner.hasNextLong()) return;
        long G = scanner.nextLong();

        // Read PC data
        // PC[j][0] and PC[j][1] for j = 0 to D-1
        long[][] PC = new long[D][2];
        for (int j = 0; j < D;
