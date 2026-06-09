import java.util.ArrayList;
import java.util.Scanner;

public class codeforces_567_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming the input is a single line of space-separated integers
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
                // Assuming valid integer input
            }
        }
        
        int N = lista.size();

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                // Case i = 0: print(f"{lista[i+1] - lista[i]} {lista[len(lista)-1] - lista[i]}")
                System.out.println((lista.get(1) - lista.get(0)) + " " + (lista.get(N - 1) - lista.get(0)));
                continue;
            } else if (i == N - 1) {
                // Case i = N - 1: print(f"{lista[len(lista)-1] - lista[len(lista)-2]} {lista[len(lista)-1] - lista[0]}")
                System.out.println((lista.get(N - 1) - lista.get(N - 2)) + " " + (lista.get(N - 1) - lista.get(0)));
                continue;
            } else {
                // Case 0 <
