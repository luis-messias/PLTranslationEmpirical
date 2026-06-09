import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class atcoder_ABC111_C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Read the list X
        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                x.add(scanner.nextInt());
            }
        }
        
        scanner.close();

        // 1. Separate into A (even indices) and B (odd indices)
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a.add(x.get(i));
            } else {
                b.add(x.get(i));
            }
        }

        // --- Processing A ---
        // Max value is 100002, so array size 100003 is needed.
        int[] cnta = new int[100003];
        for (int val : a) {
            cnta[val]++;
        }

        int vala = 0;
        int maxCnta = 0;
        int vala1 = 0;
        int maxCnta1 = 0;

        // Find most frequent (vala, maxCnta)
        for (int val : a) {
            if (cnta[val] > maxCnta) {
                maxCnta = cnta[val];
                vala = val;
            }
        }

        // Find second most frequent (vala1, maxCnta1)
        // We iterate over 'a' to ensure we only consider existing elements.
        for (int val : a) {
            if (val != vala) {
                int currentCount = cnta[val];
                if (currentCount > maxCnta1) {
                    maxCnta1 = currentCount;
                    vala1 = val;
                }
            }
        }


        // --- Processing B ---
        int[] cntb = new int[100003];
        for (int val : b) {
            cntb[val]++;
        }

        int valb = 0;
        int maxCntb = 0;
        int valb1 = 0;
        int maxCntb1 = 0;

        // Find most frequent (valb, maxCntb)
        for (int val : b) {
            if (cntb[val] > maxCntb) {
                maxCntb = cntb[val];
                valb = val;
            }
        }

        // Find second most frequent (valb1, maxCntb1)
        for (int val : b) {
            if (val != valb) {
                int currentCount = cntb[val];
                if (currentCount > maxCntb1) {
                    maxCntb1 = currentCount;
                    valb1 = val;
                }
            }
        }

        // --- Final Calculation ---
        if (valb != vala) {
            int res = 0;
            // Count elements in A not equal to vala
            for (int val : a) {
                if (val != vala) {
                    res++;
                }
            }
            // Count elements in B not equal to valb
            for (int val : b) {
                if (val != valb) {
                    res++;
                }
            }
            System.out.println(res);
        } else {
            int resa = 0;
            int resa1 = 0;
            int resb = 0;
            int resb1 = 0;

            // Calculations for A
            for (int val : a) {
                if (val != vala) {
                    resa++;
                }
                if (val != vala1) {
                    resa1++;
                }
            }

            // Calculations for B
            for (int val : b) {
                if (val != valb) {
                    resb++;
                }
                if (val != valb1) {
                    resb1++;
                }
            }
            
            System.out.println(Math.min(resa + resb1, resa1 + resb));
        }
