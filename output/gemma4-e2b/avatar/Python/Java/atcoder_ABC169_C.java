import java.util.Scanner;

public class atcoder_ABC169_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read sa and sb from the input line
        if (!scanner.hasNext()) {
            return;
        }
        String sa = scanner.next();
        
        if (!scanner.hasNext()) {
            return;
        }
        String sb = scanner.next();

        // a = int(sa)
        int a = Integer.parseInt(sa);

        // b = int(float(sb) * 100 + 0.1)
        // We parse sb as a double to handle the float operation correctly.
        double sbDouble = Double.parseDouble(sb);
        double bDouble = sbDouble * 100.0 + 0.1;
        
        // The result of the calculation is cast to int, which truncates the decimal part, 
        // matching Python's int() conversion behavior on float results.
        int b = (int) bDouble;

        // print ( a * b // 100 )
        // Use long for the multiplication to prevent potential overflow before division, 
        // although standard int range might suffice depending on constraints.
        long result = ((long) a * b) / 100;

        System.out