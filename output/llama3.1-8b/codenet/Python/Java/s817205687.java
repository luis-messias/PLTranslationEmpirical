import java.util.*;
import java.lang.Math;

public class s817205687 {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int x, int y) {
        return (x * y) / gcd(x, y);
    }

    public static int lcmList(List<Integer> numbers) {
        int result = 1;
        for (int num : numbers) {
            result = lcm(result, num);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
        }

        // 最初、Aの要素は全て偶数。2で割ったものに置き換え
        for (int i = 0; i < A.size(); i++) {
            A.set(i, A.get(i) / 2);
        }

        int countDiv2 = -1;
        for (int a : A) {
            int cnt = 0;
            while (a % 2 == 0) {
                a /= 2;
                cnt++;
            }
            if (countDiv2 == -1) {
                countDiv2 = cnt;
            } else if (cnt != countDiv2) {
                System.out.println(0);
                return;
            }
        }

        int myLcm = lcmList(A);
        if (myLcm > M) {
            System.out.println(0);
            return;
        }

        int tmp = M / myLcm;
        // my_lcmの1,2,...M倍まで使えるが、偶数は使えない
        // tmp=1or2なら1個, 3or4なら2個, 5or6なら3個,...
        int ans = (tmp + 1) / 2;
        System.out.println(ans);
    }
}