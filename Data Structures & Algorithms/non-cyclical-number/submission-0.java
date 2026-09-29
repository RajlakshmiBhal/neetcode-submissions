class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {

            int sum_squ = 0;

            // Calculate sum of squares of digits
            while (n > 0) {
                int remainder = n % 10;
                sum_squ = sum_squ + (remainder * remainder);
                n = n / 10;
            }

            n = sum_squ;

            // If we reach 1, it's a happy number
            if (n == 1) {
                return true;
            }

            // If we've seen this number before, there is a cycle
            if (set.contains(n)) {
                return false;
            }

            set.add(n);
        }

        return true;
    }
}