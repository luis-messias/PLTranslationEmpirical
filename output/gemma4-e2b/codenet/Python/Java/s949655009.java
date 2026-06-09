import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s949655009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read strn
        if (!scanner.hasNextLine()) {
            return;
        }
        String strn = scanner.nextLine();
        
        // Read n
        int n = Integer.parseInt(strn);
        
        // shichigolist
        List<String> shichigolist = List.of("3", "5", "7");
        
        // shichigo initialization
        List<List<String>> shichigo = new ArrayList<>();
        int lenStrn = strn.length();
        for (int i = 0; i < lenStrn; i++) {
            shichigo.add(new ArrayList<>());
        }
        
        // First loop: Building shichigo
        for (int i = 0; i < lenStrn; i++) {
            if (i == 0) {
                for (String j : shichigolist) {
                    shichigo.get(i).add(j);
                }
            } else {
                List<String> prevList = shichigo.get(i - 1);
                for (String j : prevList) {
                    for (String k : shichigolist) {
                        shichigo.get(i).add(j + k);
                    }
                }
            }
        }
        
        int target = lenStrn - 1;
        
        // Second loop: Modifying shichigo
        for (int i = 0; i < lenStrn; i++) {
            // Iterate over a copy of the list to safely modify the original list if needed, 
            // although the Python code iterates over a slice (shichigo[i][:])
            List<String> currentList = shichigo.get(i);
            
            for (String j : currentList) {
                if (i == target) {
                    // Case i == target
                    try {
                        int jInt = Integer.parseInt(j);
                        if (jInt > n) {
                            currentList.remove(j);
                        } else {
                            // Check if j contains '3', '5', or '7'
                            boolean contains3 = j.contains("3");
                            boolean contains5 = j.contains("5");
                            boolean contains7 = j.contains("7");
                            
                            if (!contains3 && !contains5 && !contains7) {
                                currentList.remove(j);
                            }
                        }
                    } catch (NumberFormatException e) {
                        // Should not happen if generated strings are always numeric combinations
                    }
                } else {
                    // Case i != target
                    // Check if j contains '3', '5', or '7'
                    boolean contains3 = j.contains("3");
                    boolean contains5 = j.contains("5");
                    boolean contains7 = j.contains("7");
                    
                    if (!contains3 && !contains5 && !contains7) {
                        currentList.remove(j);
                    }
                }
            }
        }
        
        // Calculate the sum of lengths
        long totalLength = 0;
        for (List<String> list : shichigo) {
            totalLength += list.size();
        }
        
        System.out.println(totalLength);
        
        scanner.close();
    }
}