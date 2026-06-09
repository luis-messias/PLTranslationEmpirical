import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class s735480710 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N (though N is not strictly used, we must consume it)
        String lineN = reader.readLine();
        if (lineN == null) return;
        
        // Read the list A
        String lineA = reader.readLine();
        if (lineA == null) return;

        String[] parts = lineA.split(" ");
        List<String> a = Arrays.asList(parts);
        int L = a.size();

        // 1. Extract odd elements (a[