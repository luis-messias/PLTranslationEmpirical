import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeforces_8_B {

    // Helper class to represent coordinates (used as map keys)
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String recordOfMovements = scanner.nextLine();
        scanner.close();

        int x = 0;
        int y = 0;

        // d_movement: Maps direction char to coordinate change (dx, dy)
        Map<Character, int[]> dMovement = new HashMap<>();
        dMovement.put('L', new int[]{0, -1});
        dMovement.put('R', new int[]{0, 1});
        dMovement.put('U', new int[]{1, 0});
        dMovement.put('D', new int[]{-1, 0});

        // d: Stores visited coordinates. Key is the Point, Value is irrelevant ('').
        Map<Point, String> d = new HashMap<>();
        d.put(new Point(0, 0), "");

        boolean bug = false;

        for (char move : recordOfMovements.toCharArray()) {
            Point temp = new Point(x, y);

            // Update coordinates
            int[] movement = dMovement.get(move);
            if (movement == null) {
                // Handle invalid move character if necessary, though input assumes valid moves
                break;
            }
            x += movement[0];
            y += movement[1];
            Point currentPos = new Point(x, y);

            // Check if the new position is unvisited
            if (!d.containsKey(currentPos)) {
                // If unvisited, run the complex bug check
                boolean foundBug = false;
                for (char step : dMovement.keySet()) {
                    int[] stepMovement = dMovement.get(step);
                    
                    // Calculate potential next position P_next
                    int nextX = x + stepMovement[0];
                    int nextY = y + stepMovement[1];
                    Point potentialNextPos = new Point(nextX, nextY);

                    // Check the condition: P_next != temp AND P_next is in d
                    if (!potentialNextPos.equals(temp) && d.containsKey(potentialNextPos)) {
                        bug = true;
                        foundBug = true;
                        break;
                    }
                }
                if (foundBug) {
                    // If bug was found in the inner loop, we break out of the outer loop
                }
            } else {
                // If the new position is already visited
                bug = true;
            }

            if (bug) {
                break;
            }

            // Record the new position
            d.put(currentPos, "");
        }

        if (bug) {
            System.out.println("BUG");
        } else {
            System.out.println("OK");
        }
    }
}