import java.util.*;
import java.io.*;

public class s137613418 {
    public static int load() throws IOException {
        return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());
    }

    public static List<Integer> loadList(String seplator, Class<?> vtype) throws IOException {
        String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(seplator);
        List<Integer> list = new ArrayList<>();
        for (String str : s) {
            if (vtype.equals(Integer.class)) {
                list.add(Integer.parseInt(str));
            } else if (vtype.equals(Long.class)) {
                list.add(Long.parseLong(str));
            } else if (vtype.equals(Float.class)) {
                list.add(Float.parseFloat(str));
            } else if (vtype.equals(Double.class)) {
                list.add(Double.parseDouble(str));
            }
        }
        return list;
    }

    public static void exit() throws IOException {
        System.exit(0);
    }

    public static List<List<Integer>> permSub(List<Integer> li, Set<Integer> used) {
        if (li.size() == used.size()) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<Integer>> k = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            if (used.contains(i)) continue;
            used.add(i);
            List<List<Integer>> subList = permSub(li, used);
            for (List<Integer> sub : subList) {
                sub.add(0, li.get(i));
            }
            k.addAll(subList);
            used.remove(i);
        }
        return k;
    }

    public static List<List<Integer>> permLi(List<Integer> li) {
        return permSub(li, new HashSet<>());
    }

    public static List<List<Integer>> permN(int n) {
        return permSub(new ArrayList<>(Collections.nCopies(n, 0)), new HashSet<>());
    }

    public static String joinI(List<Integer> li, String sep) {
        StringBuilder sb = new StringBuilder();
        for (int e : li) {
            sb.append(e);
            if (!sep.isEmpty()) sb.append(sep);
        }
        return sb.toString();
    }

    public static int li2n(List<Integer> li) {
        int n = 0;
        int base = 1;
        for (int i = li.size() - 1; i >= 0; i--) {
            n += li.get(i) * base;
            base *= 10;
        }
        return n;
    }

    public static List<Integer> sli2ili(List<String> li) {
        List<Integer> result = new ArrayList<>();
        for (String str : li) {
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    public static List<Integer> primeList(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) result.add(i);
        }
        return result;
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static List<Set<Integer>> allSubset(List<Integer> li) {
        List<Set<Integer>> result = new ArrayList<>();
        for (int bit = 0; bit < (1 << li.size()); bit++) {
            Set<Integer> ss = new HashSet<>();
            for (int i = 0; i < li.size(); i++) {
                if ((bit & (1 << i)) != 0) {
                    ss.add(li.get(i));
                }
            }
            result.add(ss);
        }
        return result;
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static long mCn(int m, int n) {
        long r = 1;
        for (int i = m; i >= m - n + 1; i--) {
            r *= i;
        }
        return r / factorial(n);
    }

    public static void main(String[] args) throws IOException {
        int n = load();
        List<Integer> A = loadList(" ", Integer.class);

        if (n == A.size()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
