public class HumanEval_102 {
    public static int chooseNum(int x, int y) {
        if (x > y) return -1;
        if (x == y) return (y % 2 == 0) ? y : -1;
        return (y % 2 == 0) ? y : y - 1;
    }
}
