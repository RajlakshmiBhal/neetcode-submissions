

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Agar character pehle se map mein hai
            if (map.containsKey(c)) {
                // left pointer ko uske last occurrence ke aage le jao
                left = Math.max(left, map.get(c) + 1);
            }

            // character ka latest index update karo
            map.put(c, right);

            // window ka size calculate karo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
