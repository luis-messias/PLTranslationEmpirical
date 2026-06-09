import java.util.*;

public class s949655009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strn = scanner.nextLine();
        int n = Integer.parseInt(strn);
        List<String> shichigolist = Arrays.asList("3", "5", "7");
        List<List<String>> shichigo = new ArrayList<>();
        for (int i = 0; i < strn.length(); i++) {
            shichigo.add(new ArrayList<>());
            if (i == 0) {
                for (String s : shichigolist) {
                    shichigo.get(i).add(s);
                }
            } else {
                for (String s : shichigo.get(i - 1)) {
                    for (String k : shichigolist) {
                        shichigo.get(i).add(s + k);
                    }
                }
            }
        }
        int target = strn.length() - 1;
        for (int i = 0; i < strn.length(); i++) {
            List<String> temp = new ArrayList<>(shichigo.get(i));
            for (String j : temp) {
                if (i == target) {
                    if (Integer.parseInt(j) > n || !j.contains("3") || !j.contains("5") || !j.contains("7")) {
                        shichigo.get(target).remove(j);
                    }
                } else {
                    if (!j.contains("3") || !j.contains("5") || !j.contains("7")) {
                        shichigo.get(i).remove(j);
                    }
                }
            }
        }
        int sum = 0;
        for (List<String> list : shichigo) {
            sum += list.size();
        }
        System.out.println(sum);
    }
}