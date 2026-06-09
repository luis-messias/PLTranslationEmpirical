import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class s964794058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memTime = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String[] memLateStr = scanner.nextLine().split(" ");
        int[] memLate = new int[memTime];
        for (int i = 0; i < memTime; i++) {
            memLate[i] = Integer.parseInt(memLateStr[i]);
        }
        
        List<Integer> colorList = new ArrayList<>();
        int highLate = 0;
        
        for (int i = 0; i < memTime; i++) {
            int member = memLate[i];
            int color = member / 400;
            if (color >= 8) {
                highLate++;
            } else if (!colorList.contains(color)) {
                colorList.add(color);
            }
        }
        
        int maxColor = colorList.size() + highLate;
        int minColor = colorList.size();
        if (minColor == 0) {
            minColor = 1;
        }
        
        System.out.println(minColor + " " + maxColor);
    }
}