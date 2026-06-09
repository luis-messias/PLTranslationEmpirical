import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s764169243 {

    static class SegmentTree {
        int size, defaultVal;
        long[] seg;

        public SegmentTree(int n, long def) {
            size = 1 << (31 - Integer.numberOfLeadingZeros(n - 1));
            defaultVal = def;
            seg = new long[2 * size];
            Arrays.fill(seg, defaultVal);
        }

        private long segfunc(long x, long y) {
            return Math.max(x, y);
        }

        public void update(int k, long x) {
            k += size - 1;
            seg[k] = x;
            while (k > 0) {
                k = (k - 1) >> 1;
                seg[k] = segfunc(seg[2 * k + 1], seg[2 * k + 2]);
            }
        }

        public long query(int p, int q) {
            if (q <= p)
                return defaultVal;
            p += size - 1;
            q += size - 2;
            long ret = defaultVal;
            while (q - p > 1) {
                if ((p & 1) == 0)
                    ret = segfunc(ret, seg[p]);
                if ((q & 1) == 1)
                    ret = segfunc(ret, seg[q--]);
                p >>= 1;
                q >>= 1;
            }
            return segfunc(segfunc(ret, seg[p]), seg[q]);
        }

        public void print() {
            System.out.println(Arrays.toString(seg));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] a = new long[N];
        for (int i = 0; i < N; i++)
            a[i] = Long.parseLong(input[i]);

        long[] ans = new long[N];
        Arrays.fill(ans, 1);
        SegmentTree leftSeg = new SegmentTree(N, 0);
        for (int i = 0; i < N; i++) {
            ans[a[i] - 1] *= i + 1 - leftSeg.query(0, a[i]);
            leftSeg.update((int) a[i] - 1, i + 1);
        }

        SegmentTree rightSeg = new SegmentTree(N, 0);
        for (int i = N - 1; i >= 0; i--) {
            ans[a[i] - 1] *= i + 1 - rightSeg.query(0, a[i]);
            rightSeg.update((int) a[i] - 1, i + 1);
        }

        long sum = 0;
        for (long x : ans)
            sum += x;

        System.out.println(sum);
    }
}