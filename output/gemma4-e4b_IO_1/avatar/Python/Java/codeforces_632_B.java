import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

class Solution {

    // Helper class to represent a piece (score and type)
    static class Piece {
        int score;
        char type;

        public Piece(int score, char type) {
            this.score = score;
            this.type = type;
        }
    }

    public static int Bob_sMaxStrength(List<Piece> pieces) {
        // Initialization: Calculate initial score based on 'B' pieces
        int pScore = 0;
        int sScore = 0;
        int pMaxScore = 0;
        int sMaxScore = 0;

        for (Piece piece : pieces) {
            if (piece.type == 'B') {
                pScore += piece.score;
                sScore += piece.score;
            }
        }
        pMaxScore = pScore;
        sMaxScore = sScore;

        // --- Player A's Max Score Calculation (Left to Right) ---
        pScore = 0;
        for (Piece piece : pieces) {
            if (piece.type == 'A') {
                pScore += piece.score;
                if (pScore > pMaxScore) {
                    pMaxScore = pScore;
                }
            } else { // piece.type == 'B'
                pScore -= piece.score;
            }
        }

        // --- Player S's Max Score Calculation (Right to Left) ---
        sScore = 0;
        int n = pieces.size();
        for (int i = n - 1; i >= 0; i--) {
            Piece piece = pieces.get(i);
            if (piece.type == 'A') {
                sScore += piece.score;
                if (sScore > sMaxScore) {
                    sMaxScore = sScore;
                }
            } else { // piece.type == 'B'
                sScore -= piece.score;
            }
        }

        // Return the maximum of the two max scores
        return Math.max(pMaxScore, sMaxScore);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read scores (Line 1)
        String scoreLine = scanner.nextLine();
        String[] scoreStrings = scoreLine.split(" ");
        int[] scores = new int[scoreStrings.length];
        for (int i = 0; i < scoreStrings.length; i++) {
            scores[i] = Integer.parseInt(scoreStrings[i]);
        }

        // Read types (Line 2)
        String type
