import java.io.*;
import java.util.*;

public class codeforces_61_B {
    static boolean valid(int i, int j, int n, int m) {
        if (i < n && i >= 0 && j >= 0 && j < m)
            return true;
        return false;
    }

    static long sumn(int i, int n) {
        return (long) (n - i) * (i + n) / 2;
    }

    static double sqfun(double a, double b, double c) {
        return (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
    }

    static int[] value() throws IOException {
        String[] s = br.readLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }

    static int[] values() throws IOException {
        String[] s = br.readLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }

    static List<Integer> inlst() throws IOException {
        String[] s = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (String str : s) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    static int inp() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    static String instr() throws IOException {
        return br.readLine();
    }

    static List<String> stlst() throws IOException {
        String[] s = br.readLine().split(" ");
        List<String> list = new ArrayList<>();
        for (String str : s) {
            list.add(str);
        }
        return list;
    }

    static String f(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-' && c != ';' && c != '_') {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = inp();
        List<String> l = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            l.add(f(instr()));
        }
        Set<String> set = new HashSet<>();
        for (String s : getPermutations(l)) {
            set.add(s);
        }
        while (t-- > 0) {
            String str = f(instr());
            if (set.contains(str)) {
                System.out.println("ACC");
            } else {
                System.out.println("WA");
            }
        }
    }

    static List<String> getPermutations(List<String> list) {
        List<String> result = new ArrayList<>();
        permute(list, 0, list.size() - 1, result);
        return result;
    }

    static void permute(List<String> list, int l, int r, List<String> result) {
        if (l == r)
            result.add(getString(list));
        else
            for (int i = l; i <= r; i++) {
                swap(list, l, i);
                permute(list, l + 1, r, result);
                swap(list, l, i);
            }
    }

    static String getString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    static void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    static BufferedReader br;
    static {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}