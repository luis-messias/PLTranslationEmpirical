import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class atcoder_AGC043_B {

    // Corresponds to twos_in_factorial(n) = n - bin(n).count('1')
    private static int twosInFactorial(int n) {
        // Integer.bitCount(n) calculates the number of set bits (popcount)
        return n - Integer.bitCount(n);
    }

    // Corresponds to parity_of_nCr(n, i)
    private static boolean parityOfNCr(int n, int i) {
        // f(n) - f(n - i) - f(i) > 0
        return twosInFactorial(n) - twosInFactorial(n - i) - twosInFactorial(i) > 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        // Read the list of numbers (nums)
        if (!scanner.hasNextLine()) return;
        String line = scanner.nextLine().trim();
        
        List<Integer> nums = new ArrayList<>();
        if (!line.isEmpty()) {
            String[] parts = line.split("\\s+");
            for (String part : parts) {
                try {
                    int x = Integer.parseInt(part);
                    // Corresponds to int(x) - 1
                    nums.add(x - 1);
                } catch (NumberFormatException e) {
                    // Handle potential parsing errors if input format is strict
                }
            }
        }

        boolean noOne = false;
        
        // Check if 1 is in nums
        boolean onePresent = false;
        for (int num : nums) {
            if (num == 1) {
                onePresent = true;
                break;
            }
        }

        if (!onePresent) {
            // nums = [ num // 2 for num in nums ]
            List<Integer> newNums = new ArrayList<>();
            for (int num : nums) {
                newNums.add(num / 2);
            }
            nums = newNums;
            noOne = true;
        }

        boolean isOdd = false;
        
        // Loop through nums (i is the index)
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            
            // Corresponds to parity_of_nCr(n - 1, i)
            if (!parityOfNCr(n - 1, i) && (num & 1) != 0) {
                isOdd ^= 1;
            }
        }

        if (!isOdd) {
            System.out.println(0);
        } else {
            // print(1 << no_one)
            System.out.println(1 << noOne);
        }
        
        scanner.close();
    }
}
