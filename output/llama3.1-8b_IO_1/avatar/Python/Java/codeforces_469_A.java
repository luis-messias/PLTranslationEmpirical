import java.util.*;

public class codeforces_469_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxLevel = Integer.parseInt(scanner.nextLine());
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        String input1 = scanner.nextLine();
        String[] splitInput1 = input1.split(" ");
        for (String s : splitInput1) {
            if (!s.equals(splitInput1[0])) {
                x.add(Integer.parseInt(s));
            }
        }

        String input2 = scanner.nextLine();
        String[] splitInput2 = input2.split(" ");
        for (String s : splitInput2) {
            if (!s.equals(splitInput2[0])) {
                y.add(Integer.parseInt(s));
            }
        }

        x.remove(0);
        y.remove(0);

        Set<Integer> setX = new HashSet<>(x);
        Set<Integer> setY = new HashSet<>(y);

        if (setX.contains(0)) {
            setX.remove(0);
        } else if (setY.contains(0)) {
            setY.remove(0);
        }

        Set<Integer> z = new HashSet<>();
        z.addAll(setX);
        z.addAll(setY);

        if (!z.contains(0) && z.size() == maxLevel) {
            System.out.println("I become the guy.");
        } else {
            System.out.println("Oh, my keyboard!");
        }
    }
}
