class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // carry nikalna
            a = a ^ b;                // bina carry ka sum
            b = carry;                // carry ko add karna hai next round me
        }
        return a;
        
    }
}
