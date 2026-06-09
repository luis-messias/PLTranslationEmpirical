package com.example;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_17 {

    public static List<Integer> parseMusic(String musicString) {
        """ Input to this function is a string representing musical notes in a special ASCII format.
            Your task is to parse this string and return list of integers corresponding to how many beats does each
            note last.

            Here is a legend:
            'o' - whole note, lasts four beats
            'o|' - half note, lasts two beats
            '.|' - quater note, lasts one beat

        >>> parseMusic('o o| .| o| o| .| .| .| .| o o')
        [4, 2, 1, 2, 2, 1, 1, 1, 1, 4, 4]
        """

        List<Integer> beats = new ArrayList<>();

        if (musicString.isEmpty()) {
            return beats;
        }

        String[] notes = musicString.split(" ");

        for (String note : notes) {
            int beatCount;

            switch (note.charAt(0)) {
                case 'o':
                    beatCount = 4;
                    break;
                case '|':
                    if (note.length() == 2 && note.charAt(1) == '.') { // half note
                        beatCount = 2;
                    } else if (note.length() > 2 || !note.contains('|')) {
                        throw new IllegalArgumentException("Invalid musical notation");
                    }
                    break;

                case '.':
                    if (note.length() == 3 && note.charAt(1) == '|') { // quater note
                        beatCount = 1;
                    } else {
                        throw new IllegalArgumentException("Invalid musical notation");
                    }

                    break;

                default:
                    throw new IllegalArgumentException("Unknown character in music string: " + Character.toString(note.charAt(0)));
            }
            
            beats.add(beatCount);
        }

        return beats;
    }

    public static void main(String[] args) {
        List<Integer> result = parseMusic('o o| .| o| o| .| .| .| .| o o');
        System.out.println(result); // Output: [4, 2, 1, 2, 2, 1, 1, 1, 1, 4, 4]
    }
}
