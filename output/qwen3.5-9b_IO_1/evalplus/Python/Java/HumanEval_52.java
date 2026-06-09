public class HumanEval_52 {
    public static boolean belowThreshold(List<Integer> l, int t) {
        return l.stream().allMatch(x -> x < t);
    }
}
