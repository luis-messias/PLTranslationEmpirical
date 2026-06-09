import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class HumanEval_15 {
    public static String stringSequence(int n) {
        return IntStream.rangeClosed(0, n)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "));
    }
}
