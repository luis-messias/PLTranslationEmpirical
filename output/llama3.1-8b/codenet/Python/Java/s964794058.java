import java.util.*;

public class s964794058 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memTime = Integer.parseInt(scanner.nextLine());
        String[] memLateStr = scanner.nextLine().split(" ");
        List<Integer> memLate = new ArrayList<>();
        for (String s : memLateStr) {
            memLate.add(Integer.parseInt(s));
        }
        Set<Integer> colorList = new HashSet<>();
        int highLate = 0;
        for (int i = 0; i < memTime; i++) {
            int member = memLate.get(i);
            if (member / 400 >= 8) {
                highLate++;
            } else if (!colorList.contains(member / 400)) {
                colorList.add(member / 400);
            }
        }
        int maxColor = colorList.size() + highLate;
        int minColor = colorList.isEmpty() ? 1 : colorList.size();
        System.out.println(minColor + " " + maxColor);
    }
}