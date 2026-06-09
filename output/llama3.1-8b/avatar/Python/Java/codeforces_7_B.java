import java.util.Scanner;
import java.util.Arrays;

public class codeforces_7_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] alocuente = new int[m];
        Arrays.fill(alocuente, 0);
        int ind = 1;
        for (int i = 0; i < t; i++) {
            String[] op = scanner.nextLine().split(" ");
            if (op[0].equals("alloc")) {
                int pos = 0;
                boolean found = false;
                for (int j = 0; j < m; j++) {
                    if (alocuente[j] == 0) {
                        pos++;
                        if (pos == Integer.parseInt(op[1])) {
                            Arrays.fill(alocuente, j - Integer.parseInt(op[1]) + 1, j + 1, ind);
                            System.out.println(ind);
                            ind++;
                            found = true;
                            break;
                        }
                    } else {
                        pos = 0;
                    }
                }
                if (!found) {
                    System.out.println("NULL");
                }
            }
            if (op[0].equals("erase")) {
                int pos = Integer.parseInt(op[1]);
                if ((pos != 0 && Arrays.binarySearch(alocuente, pos) < 0) || pos == 0) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                } else {
                    for (int j = 0; j < m; j++) {
                        if (alocuente[j] == pos) {
                            alocuente[j] = 0;
                        }
                    }
                }
            }
            if (op[0].equals("defragment")) {
                int cnt = 0;
                for (int j : alocuente) {
                    if (j == 0) {
                        cnt++;
                    }
                }
                int[] newAlocuente = new int[m - cnt];
                int k = 0;
                for (int j : alocuente) {
                    if (j != 0) {
                        newAlocuente[k++] = j;
                    }
                }
                System.arraycopy(newAlocuente, 0, alocuente, 0, m - cnt);
                Arrays.fill(alocuente, m - cnt, m, 0);
            }
        }
    }
}