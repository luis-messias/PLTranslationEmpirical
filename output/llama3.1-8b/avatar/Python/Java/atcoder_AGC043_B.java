public class atcoder_AGC043_B {
    public static int twosInFactorial(int n) {
        String binary = Integer.toBinaryString(n);
        return n - binary.replace("0", "").length();
    }

    public static boolean parityOfNCr(int n, int i) {
        return twosInFactorial(n) - twosInFactorial(n - i) - twosInFactorial(i) > 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine().trim();
        int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean noOne = false;
        if (!Arrays.asList(nums).contains(1)) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] /= 2;
            }
            noOne = true;
        }

        boolean isOdd = false;
        for (int i = 0; i < nums.length; i++) {
            if (!parityOfNCr(n - 1, i) && nums[i] % 2 != 0) {
                isOdd ^= true;
            }
        }

        if (!isOdd) {
            System.out.println(0);
        } else {
            System.out.println((noOne ? 1 : 0) << 1);
        }
    }
}