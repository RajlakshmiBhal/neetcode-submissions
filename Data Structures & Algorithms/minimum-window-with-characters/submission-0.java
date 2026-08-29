class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];  // frequency of t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int[] window = new int[128];

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c]++;

            if (need[c] > 0 && window[c] <= need[c]) {
                count++;
            }

            // When window contains all chars of t
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    count--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
