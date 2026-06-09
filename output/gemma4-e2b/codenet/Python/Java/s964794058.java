import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s964794058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read memTime
        if (!scanner.hasNextInt()) return;
        int memTime = scanner.nextInt();

        // Read memLate elements (assuming they are on the next line)
        if (!scanner.hasNextLine()) return;
        String line = scanner.nextLine();
        String[] memLateStr = line.split(" ");

        // Convert to integers
        int[] memLate = new int[memTime];
        for (int i = 0; i < memTime; i++) {
            if (i < memLateStr.length) {
                memLate[i] = Integer.parseInt(memLateStr[i]);
            }
        }

        List<Integer> colorList = new ArrayList<>();
        int highLate = 0;

        for (int color = 0; color < memTime; color++) {
            int member = memLate[color];
            int colorValue = member / 400;

            if (colorValue >= 8) {
                highLate++;
            } else {
                // Check if colorValue is in colorList (equivalent to Python's 'in' check)
                boolean isInList = false;
                for (int c : colorList) {
                    if (c == colorValue) {
                        isInList = true;
                        break;
                    }
                }

                if (!isInList) {
                    colorList.add(colorValue);
                }
            }
        }

        int maxColor = colorList.size() + highLate;
        int minColor = colorList.size();

        if (minColor == 0) {
            minColor = 1;
        }

        System.out.println(minColor + " " + maxColor);
        
        scanner.close();
    }
}