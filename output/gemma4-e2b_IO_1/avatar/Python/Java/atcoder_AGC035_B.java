import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class atcoder_AGC035_B {

    static class Edge implements Comparable<Edge> {
        int degree;
        int vertex;

        public Edge(int degree, int vertex) {
            this.degree = degree;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge other) {
            // Min-heap based on degree
            return Integer.compare(this.degree, other.degree);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // edges[i] stores the set of neighbors of vertex i (0-indexed)
        @SuppressWarnings("unchecked")
        Set<Integer>[] edges = new HashSet[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new HashSet<>();
        }

        // degs[i] stores the degree of vertex i
        int[] degs = new int[N];
        // parity[i] stores the parity state for vertex i (0 or 1)
        int[] parity = new int[N];
        // flag[i] tracks if vertex i has been processed
        boolean[] flag = new boolean[N];

        for
