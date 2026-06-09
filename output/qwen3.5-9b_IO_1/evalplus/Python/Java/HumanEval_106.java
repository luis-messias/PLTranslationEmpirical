public class HumanEval_106 {
    public static java.util.List<Integer> f(int n) {
        if (n == 0) return new java.util.ArrayList<>();
        if (n == 1) return java.util.Arrays.asList(1);
        if (n == 2) return java.util.Arrays.asList(1, 2);

        java.util.List<Integer> ans = new java.util.ArrayList<>();
        ans.add(1);
        ans.add(2);
        
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 1) {
                ans.add(ans.get(ans.size() - 2) + (i - 1) + i);
            } else {
                ans.add(ans.get(ans.size() - 2) * (i - 1) * i);
            }
        }
        return ans;
    }
}
