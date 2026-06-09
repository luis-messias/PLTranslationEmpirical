import java.util.List;
import java.util.stream.Collectors;

public class HumanEval_81 {

    private static String toLetterGrade(double score) {
        if (score == 4.0) {
            return "A+";
        } else if (score > 3.7) {
            return "A";
        } else if (score > 3.3) {
            return "A-";
        } else if (score > 3.0) {
            return "B+";
        } else if (score > 2.7) {
            return "B";
        } else if (score > 2.3) {
            return "B-";
        } else if (score > 2.0) {
            return "C+";
        } else if (score > 1.7) {
            return "C";
        } else if (score > 1.3) {
            return "C-";
        } else if (score > 1.0) {
            return "D+";
        } else if (score > 0.7) {
            return "D";
        } else if (score > 0.0) {
            return "D-";
        } else {
            return "E";
        }
    }

    public static List<String> numericalLetterGrade(List<Double> grades) {
        return grades.stream()
                .map(HumanEval_81::toLetterGrade)
                .collect(Collectors.toList());
    }
}
