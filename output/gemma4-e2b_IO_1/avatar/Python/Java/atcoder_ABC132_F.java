import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class atcoder_ABC132_F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and K
        String line = br.readLine();
        if (line == null || line.isEmpty()) return;
        StringTokenizer st = new StringTokenizer(line);
        
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long mod = 1_000_
