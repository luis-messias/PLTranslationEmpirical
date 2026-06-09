import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_632_B {

    public static int bobSMaxStrength(List<int[]> pieces) {
        // pScore, sScore, pMaxScore, sMaxScore initialization
        int pScore = 0;
        int sScore = 0;
        int pMaxScore = Integer.MIN_VALUE; // Initialize to a very small number for finding max
        int sMaxScore = Integer.MIN_VALUE; // Initialize to a very small number for finding max

        // Initialization based on the Python: sum ( piece [ 0 ] for piece in pieces if piece [ 1 ] == 'B' )
        for (int[] piece : pieces) {
            if (piece[1] == 'B') {
                pScore += piece[0];
            }
        }
        // sScore is implicitly initialized to 0 if we follow the Python logic strictly, 
        // but the Python code initializes sScore based on the same condition:
        // pScore = sScore = pMaxScore = sMaxScore = sum ( piece [ 0 ] for piece in pieces if piece [ 1 ] == 'B' )
        // This means sScore is also initialized to the sum of scores where piece[1] == 'B'.
        sScore = pScore; 
        pMaxScore = pScore;
        sMaxScore = pScore;


        // First loop (calculating pMaxScore and updating pScore)
        for (int[] piece : pieces) {
            if (piece[1] == 'A') {
                pScore += piece[0];
                if (pScore > pMaxScore) {
                    pMaxScore = pScore;
                }
            }