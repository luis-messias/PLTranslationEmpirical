import java.util.List;

public class HumanEval_133 {
    public static int sumSquares(List<Double> lst) {
        return (int) lst.stream()
            .mapToDouble(x -> Math.pow(Math.ceil(x), 2))
            .sum();
    }
}
