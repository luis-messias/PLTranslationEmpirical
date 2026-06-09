import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class atcoder_AGC021_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read all tokens from standard input
        String line = scanner.nextLine();
        String[] tokens = line.split("\\s+");
        
        if (tokens.length == 0) {
            return;
        }

        // The first token is N, the rest are coordinates
        // N is tokens[0]
        // Coordinates start from index 1
        
        // We need to parse the coordinates. Since the Python code uses *XY, 
        // we assume the input is N followed by 2N coordinates.
        
        // If the input is N, x1, y1, x2, y2, ...
        // N = Integer.parseInt(tokens[0]);
        
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < tokens.length; i += 2) {
            if (i + 1 < tokens.length) {
                int x = Integer.parseInt(tokens[i]);
                int y = Integer.parseInt(tokens[i + 1]);
                points.add(new Point(x, y));
            }
        }

        if (points.size() < 2) {
            // Cannot perform calculations if there are fewer than 2 points
            return;
        }

        double ans = 0.0;
        int N = points.size();

        for (int i = 0; i < N; i++) {
            Point currentPoint = points.get(i);
            
            // Calculate angles relative to currentPoint
            List<Double> D = new ArrayList<>();
            
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                
                Point otherPoint = points.get(j);
                
                // Calculate angle using atan2(y - y1, x - x1)
                double angle = Math.atan2(otherPoint.y - currentPoint.y, otherPoint.x - currentPoint.x);
                D.add(angle);
            }
            
            // Sort the angles
            D.sort(Double::compare);
            
            // The Python code calculates D[0] (the smallest angle) and then appends D[0] + 2*pi
            // This seems to be a specific way to handle the wrap-around for the angular span.
            
            if (!D.isEmpty()) {
                double firstAngle = D.get(0);
                D.add(firstAngle + 2 * Math.PI);
            }
            
            // Calculate the angular span (ans calculation)
            double currentAns = 0.0;
            
            // Iterate over adjacent angles (D[k] and D[k+1])
            for (int k = 0; k < D.size() - 1; k++) {
                double a = D.get(k);
                double b = D.get(k + 1);
                
                // Check if the difference is >= pi
                if (b - a >= Math.PI) {
                    currentAns = (b - a) - Math.PI;
                }
            }
            
            ans += currentAns;
        }

        // Final result: ans / (2 * pi)
        System.out.printf("%.10f%n", ans / (2 * Math.PI));
    }

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}