class Solution {
    public int longestConsecutive(int[] nums) {

        // Store all numbers in a HashSet.
        // HashSet allows us to check whether a number exists
        // in O(1) average time.
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Check every number
        for (int num : set) {

            // If num - 1 does NOT exist,
            // then num is the beginning of a sequence.
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                // Keep checking the next consecutive number.
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the longest sequence found so far.
                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}