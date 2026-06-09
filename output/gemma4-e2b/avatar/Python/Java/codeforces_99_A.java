import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class codeforces_99_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input line
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String l = scanner.nextLine();
        
        // l = l.split('.')
        String[] parts = l.split("\\.");
        
        // s = list(l[0])
        List<String> sList = Arrays.asList(parts[0].chars().mapToObj(c -> String.valueOf((char) c)).toArray(String[]::new));
        
        // p = list(l[1])
        List<String> pList = Arrays.asList(parts[1].chars().mapToObj(c -> String.valueOf((char) c)).toArray(String[]::new));
        
        // i = int(p[0])
        int i = Integer.parseInt(pList.get(0));
        
        // Check the last element of s
        String lastS = sList.get(sList.size() - 1);
        
        if (lastS.equals("9")) {
            System.out.println("GOTO Vasilisa.");
        } else if (!lastS.equals("9") && i < 5) {
            // s = "".join(s)
            String s = String.join("", sList.toArray(new String[0]));
            System.out.println(s);
        } else {
            // s = "".join(s)