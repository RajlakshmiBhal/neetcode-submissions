

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency map for s1
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int n = s1.length();
        HashMap<Character, Integer> window = new HashMap<>();

        // First window
        for (int i = 0; i < n; i++) {
            char c = s2.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        if (window.equals(map)) return true;

        // Slide the window
        for (int i = n; i < s2.length(); i++) {
            char add = s2.charAt(i);
            char remove = s2.charAt(i - n);

            // Add new char
            window.put(add, window.getOrDefault(add, 0) + 1);

            // Remove old char
            if (window.get(remove) == 1) {
                window.remove(remove);
            } else {
                window.put(remove, window.get(remove) - 1);
            }

            // Compare maps
            if (window.equals(map)) return true;
        }

        return false;
    }
}
