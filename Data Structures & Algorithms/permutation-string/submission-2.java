class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        // Frequency of s1
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int k = s1.length();

        // Sliding window over s2
        for (int right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;

            // Keep window size = k
            if (right >= k) {
                window[s2.charAt(right - k) - 'a']--;
            }

            // Compare frequencies
            if (right >= k - 1 && matches(need, window)) {
                return true;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
