import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class atcoder_ABC155_E {
    public static void main(String[] args) throws IOException {
        String inputMethod = "key";
        int mod = 1000000007;
        Scanner scanner;

        if (System.getProperty("os.name").contains("Windows")) {
            switch (inputMethod) {
                case "clipboard":
                    System.out.println("Clipboard input not supported on Windows.");
                    break;
                case "file":
                    File inputFile = new File("inputFile.txt");
                    scanner = new Scanner(inputFile);
                    break;
                default:
                    scanner = new Scanner(System.in);
            }
        } else if (System.getProperty("os.name").contains("Linux") || System.getProperty("os.name").contains("Mac")) {
            switch (inputMethod) {
                case "clipboard":
                    String clipboardText = getClipboard();
                    String[] lines = clipboardText.split("\n");
                    scanner = new Scanner(lines[0]);
                    break;
                case "file":
                    File inputFile = new File("inputFile.txt");
                    scanner = new Scanner(inputFile);
                    break;
                default:
                    scanner = new Scanner(System.in);
            }
        } else {
            System.out.println("Unsupported operating system.");
            return;
        }

        int pp = 0;
        int na = 0;

        String s = scanner.nextLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int cc = na + Character.getNumericValue(c);
            na = 0;
            if (cc <= 4) {
                pp += cc;
            } else {
                na = 1;
                if (i == 0) {
                    pp += 1;
                }
                pp += 10 - cc;
            }
        }

        System.out.println(pp);
    }

    public static String getClipboard() throws IOException, InterruptedException {
        Process clipboardProcess = Runtime.getRuntime().exec("pbpaste");
        BufferedReader reader = new BufferedReader(new InputStreamReader(clipboardProcess.getInputStream()));
        return reader.readLine();
    }
}