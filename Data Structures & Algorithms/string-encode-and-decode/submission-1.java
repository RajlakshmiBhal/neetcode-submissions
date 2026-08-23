class Solution {

    // Encode a list of strings to a single string
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            // Append length, separator, and the string itself
            result.append(str.length()).append("#").append(str);
        }

        return result.toString();
    }

    // Decode a single string back to a list of strings
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;

            // Find the position of '#'
            while (s.charAt(j) != '#') {
                j++;
            }

            // Extract length of the next string
            int length = Integer.parseInt(s.substring(i, j));

            // Move index to start of actual string
            i = j + 1;

            // Extract the string of given length
            String str = s.substring(i, i + length);
            result.add(str);

            // Move index to next encoded string
            i = i + length;
        }

        return result;
    }
}
