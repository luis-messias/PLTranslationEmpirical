import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codeforces_632_B {

    public static int bobSMaxStrength(List<int[]> pieces) {
        // Initialization: pScore, sScore, pMaxScore, sMaxScore
        // pScore, sScore, pMaxScore, sMaxScore = sum ( piece [ 0 ] for piece in pieces if piece [ 1 ] == 'B' )
        int pScore = 0;
        int sScore = 0;
        int pMaxScore = 0;
        int sMaxScore = 0;

        // Calculate initial scores based on 'B' pieces
        for (int[] piece : pieces) {
            if (piece[1] == 'B') {
                pScore += piece[0];
                sScore += piece[0]; // Initialize sScore to the same value as pScore
            }
        }
        
        // The Python code initializes all four variables to the same sum of scores where piece[1] == 'B'.
        // Let's re-read the Python initialization:
        // pScore = sScore = pMaxScore = sMaxScore = sum ( piece [ 0 ] for piece in pieces if piece [ 1 ] == 'B' )
        
        pScore = sScore = pMaxScore = sMaxScore;
        for (int[] piece : pieces) {
            if (piece[1] == 'B') {
                pScore += piece[0];
            }
        }
        // Since pScore is calculated above, pMaxScore and sMaxScore are initialized to this sum.
        pMaxScore = pScore;
        sMaxScore = pScore;


        // First loop (calculating pMaxScore and updating pScore)
        // This loop iterates over all pieces and adjusts pScore based on 'A' vs 'B'
        for (int[] piece : pieces) {
            if (piece[1] == 'A') {
                pScore += piece[0];
                if (pScore > pMaxScore) {
                    pMaxScore = pScore;
                }
            } else { // piece[1] == 'B'
                pScore -= piece[0];
            }
        }

        // Second loop (calculating sMaxScore and updating sScore, iterating backwards)
        // This loop iterates over all pieces and adjusts sScore based on 'A' vs 'B'
        for (int i = pieces.size() - 1; i >= 0; i--) {
            if (pieces.get(i)[1] == 'A') {
                sScore += pieces.get(i)[0];
                if (sScore > sMaxScore) {
                    sMaxScore = sScore;
                }
            } else { // piece[1] == 'B'
                sScore -= pieces.get(i)[0];
            }
        }

        // Final comparison and return
        if (pMaxScore > sMaxScore) {
            return pMaxScore;
        }
        return sMaxScore;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The Python input reading was: pieces = tuple ( zip ( map ( int , input ( ).split ( ) ) , input ( ) )
        // This suggests reading two lines of input. We assume the input provides scores and types for both groups.

        // Read the first line (for Bob/B group)
        if (!scanner.hasNextLine()) return;
        String line1 = scanner.nextLine();

        // Read the second line (for Alice/A group)
        if (!scanner.hasNextLine()) return;
        String line2 = scanner.nextLine();
        
        // Parse the
