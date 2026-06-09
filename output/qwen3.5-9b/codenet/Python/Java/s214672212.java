import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class s214672212 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        
        String[] input = scanner.nextLine().split(" ");
        for (String s : input) {
            nums.add(Integer.parseInt(s));
        }
        
        Collections.sort(nums, Collections.reverseOrder());
        
        System.out.println(nums.get(0) * 10 + nums.get(1) + nums.get(2));
    }
}