import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class codeforces_7_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read t and m
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(line1);
        
        if (!st.hasMoreTokens()) return;
        int t = Integer.parseInt(st.nextToken());
        
        if (!st.hasMoreTokens()) return;
        int m = Integer.parseInt(st.nextToken());

        // Initialize alocuente (using int array)
        int[] alocuente = new int[m];
        // alocuente is initialized to 0 by default.

        int ind = 1;

        for (int i = 0; i < t; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine();
            StringTokenizer opSt = new StringTokenizer(line);
            
            if (!opSt.hasMoreTokens()) continue;
            String command = opSt.nextToken();

            if (command.equals("alloc")) {
                if (!opSt.hasMoreTokens()) continue;
                int size = Integer.parseInt(opSt.nextToken());
                
                if (size <= 0) continue;
