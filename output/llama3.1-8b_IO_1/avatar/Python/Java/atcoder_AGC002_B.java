import java.util.Scanner;

public class atcoder_AGC002_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[100][2];
        int rows = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                String[] parts = line.split(" ");
                for (int i = 0; i < parts.length; i++) {
                    matrix[rows][i] = Integer.parseInt(parts[i]);
                }
                rows++;
            }
        }

        int[][] sortedMatrix = new int[rows][2];
        System.arraycopy(matrix, 0, sortedMatrix, 0, rows);

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < rows - i - 1; j++) {
                if (sortedMatrix[j][0] > sortedMatrix[j + 1][0]) {
                    int temp = sortedMatrix[j][0];
                    sortedMatrix[j][0] = sortedMatrix[j + 1][0];
                    sortedMatrix[j + 1][0] = temp;

                    temp = sortedMatrix[j][1];
                    sortedMatrix[j][1] = sortedMatrix[j + 1][1];
                    sortedMatrix[j + 1][1] = temp;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < rows - 1; i++) {
            if (sortedMatrix[i][1] == sortedMatrix[i + 1][1]) {
                sum += Math.abs(sortedMatrix[i][0] - sortedMatrix[i + 1][0]);
            }
        }

        System.out.println(sum);
    }
}
