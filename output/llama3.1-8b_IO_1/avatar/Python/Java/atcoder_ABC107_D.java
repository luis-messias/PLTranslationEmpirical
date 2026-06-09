import java.util.*;

class BIT {
    int size;
    int[] tree;

    public BIT(int N) {
        this.size = N;
        this.tree = new int[N + 1];
    }

    private int _bitsum(int i) {
        int ret = 0;
        while (i > 0) {
            ret += tree[i];
            i ^= i & -i;
        }
        return ret;
    }

    public int bitsum(int l, int r) {
        if (r == Integer.MIN_VALUE) {
            return _bitsum(l);
        } else {
            return _bitsum(r) - _bitsum(l);
        }
    }

    public void bitadd(int i, int x) {
        i++;
        while (i <= size) {
            tree[i] += x;
            i += i & -i;
        }
    }
}

public class atcoder_ABC107_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = n * (n + 1) / 4;
        String[] input = scanner.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            d.put(list.get(i), i);
        }
        int[] b = new int[n];
        for (int x : a) {
            b[d.get(x)] = 1;
        }

        for (int i = 0; i < n; i++) {
            b[i + 1] += b[i];
        }

        int c = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (b[i + 1] < c) {
                c = b[i + 1];
            }
        }

        BIT bit = new BIT(c);
        int ans = 0;
        for (int x : b) {
            if (x == 1) {
                ans += bit.bitsum(x);
                bit.bitadd(x, 1);
            }
        }

        int[] t = {list.size(), 0};
        while (t[0] - t[1] > 1) {
            int mid = (t[0] + t[1]) / 2;
            if (check(mid, list, b, bit)) {
                t[0] = mid;
            } else {
                t[1] = mid;
            }
        }

        System.out.println(list.get(t[1]));
    }

    public static boolean check(int X) {
        for (int i = 0; i < X; i++) {
            if (X - i <= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean check(int X, List<Integer> list, int[] b, BIT bit) {
        for (int i = 0; i < b.length; i++) {
            if (b[i + 1] >= X) {
                return true;
            }
        }
        return false;
    }

    public static boolean check(int X, List<Integer> list, int[] b, BIT bit, int c) {
        int[] b2 = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            if (b[i + 1] >= X) {
                b2[i + 1] = 1;
            } else {
                b2[i + 1] = 0;
            }
        }

        for (int i = 0; i < b2.length; i++) {
            b2[i + 1] += b2[i];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < b2.length; i++) {
            if (b2[i + 1] < min) {
                min = b2[i + 1];
            }
        }

        BIT bit2 = new BIT(min);
        int ans = 0;
        for (int x : b2) {
            if (x == 1) {
                ans += bit2.bitsum(x);
                bit2.bitadd(x, 1);
            }
        }

        return ans >= X * list.size();
    }
}
