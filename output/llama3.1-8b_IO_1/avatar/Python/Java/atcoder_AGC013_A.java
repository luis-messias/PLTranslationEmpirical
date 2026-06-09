import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class atcoder_AGC013_A {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        Collections.sort(numbers);
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 1 && i != numbers.size() - 1) {
                sum += numbers.get(i);
            }
        }
        System.out.println(sum);
    }
}
