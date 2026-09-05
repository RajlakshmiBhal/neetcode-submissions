class Solution {
    public int missingNumber(int[] nums) {

        int expected = 0 ;
        for(int i = 0 ; i <= nums.length ; i++)
        {
            expected ^= i;
        }
        int actual = 0 ;
        for(int j = 0; j < nums.length ; j++)
        {
            actual ^= nums[j];
        }
        return expected ^ actual;
        
    }
}
