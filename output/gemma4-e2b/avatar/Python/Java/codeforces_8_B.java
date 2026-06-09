import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        // Simple hash code calculation
        return 31 * x + y;
    }
}

public class codeforces_8_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input record of movements
        if (!scanner.hasNextLine()) {
            return;
        }
        String recordOfMovements = scanner.nextLine();
        scanner.close();

        int x = 0;
        int y = 0;

        // d_movement: Map direction to delta (dx, dy)
        Map<Character, Coordinate> d_movement = new HashMap<>();
        d_movement.put('L', new Coordinate(0, -1));
        d_movement.put('R', new Coordinate(0, 1));
        d_movement.put('U', new Coordinate(1, 0));
        d_movement.put('D', new Coordinate(-1, 0));

        // d: Map coordinates to empty string (visited tracking)
        Map<Coordinate, String> d = new HashMap<>();
        d.put(new Coordinate(x, y), "");

        boolean bug = false;

        for (char move : recordOfMovements.toCharArray()) {
            Coordinate temp = new Coordinate(x, y);

            // Calculate new position
            Coordinate delta = d_movement.get(move);
            x += delta.x;
            y += delta.y;
            
            Coordinate currentPos = new Coordinate(x, y);

            if (!d.containsKey(currentPos)) {
                // Check for bug condition
                boolean foundBug = false;
                
                for (Map.Entry<Character, Coordinate> entry : d_movement.entrySet()) {
                    Coordinate step = entry.getValue();
                    
                    Coordinate nextPos = new Coordinate(x + step.x, y + step.y);
                    
                    // Check if nextPos is different from temp AND nextPos is in d
                    if (!nextPos.equals(temp) && d.containsKey(nextPos)) {
                        bug = true;
                        foundBug = true;
                        break;
                    }
                }
                
                if (foundBug) {
                    // If bug found in the inner loop, we break out of the outer loop too
                    break;
                }
            } else {
                // If (x, y) is already in d (which shouldn't happen if the check above is correct, 
                // but following the Python structure)
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