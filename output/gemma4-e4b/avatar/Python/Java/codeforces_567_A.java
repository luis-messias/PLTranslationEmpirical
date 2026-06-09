import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class codeforces_567_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The Python code structure suggests reading an initial integer (inp), 
        // and then reading the list from a subsequent input line.
        // Since we cannot reliably simulate two separate inputs without knowing the exact environment,
        // we assume the input provided to the program is the space-separated list of integers.
        
        // Reading the entire line of input and splitting it.
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        String[] tokens = line.trim().split("\\s+");
        
        if (tokens.length == 0 || (tokens.length == 1 && tokens[0].isEmpty())) {
            return;
        }

        ArrayList<Integer> lista = new ArrayList<>();
        for (String token : tokens) {
            try {
                lista.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                // Handle case where token might not be a valid integer
                // For this translation, we assume valid integer input.
            }
        }
        
        int N = lista.size();

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                // Case i = 0
                // print(f"{lista[i+1] - lista[i]} {lista[len(lista)-1] - lista[i]}")
                System.out.println((lista.get(1) - lista.get(0)) + " " + (lista.get(N - 1) - lista.get(0)));
                continue;
            } else if (i == N - 1) {
                // Case i = N - 1
                // print(f"{lista[len(lista)-1] - lista[len(lista)-2]} {lista[len(lista)-1] - lista[0]}")
                System.out.println((lista.get(N - 1) - lista.get(N - 2)) + " " + (lista.get(N - 1) - lista.get(0)));
                continue;
            } else {
                // Case 0 < i < N - 1
                
                // First conditional print statement
                int diff1_prev = lista.get(i) - lista.get(i - 1);
                int diff2_next = lista.get(i + 1) - lista.get(i);
                
                if (diff1_prev > diff2_next) {
                    // print(lista[i+1] - lista[i], end = " ")
                    System.out.print(diff2_next + " ");
                } else {
                    // print(lista[i] - lista[i-1], end = " ")
                    System.out.print(diff1_prev + " ");
                }

                // Second conditional print statement
                int diff_