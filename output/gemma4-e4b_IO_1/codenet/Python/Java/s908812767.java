import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * Given a list of integers nums, return the length of the longest consecutive sequence.
     * The sequence does not have to be in the original array.
     *
     * @param nums The list of integers.
     * @return The length of the longest consecutive sequence.
     */
    public int longestConsecutive(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        // Use a HashSet for O(1) average time complexity lookups
        java.util.Set<Integer> numSet = new java.util.HashSet<>(nums);
        int longestStreak = 0;

        // Iterate through the set to find the start of a sequence
        for (int num : numSet) {
            // Check if 'num' is the start of a sequence.
            // A number is the start if num - 1 is NOT present in the set.
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the consecutive sequence starting from 'num'
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the maximum streak found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
