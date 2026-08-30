class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1 , right = 0;

        for(int n : piles)
        {
          right = Math.max(n , right);
        } 

        int ans = right ;

        while (left <= right)
        {
           int  mid = left + (right - left ) / 2;

            if(canFinish(piles , h , mid))
            {
                ans = mid ;
                right = mid - 1 ;
            }else{
                left = mid + 1;
            }
        }
        return ans;   
    }
     boolean canFinish(int[] piles ,int h ,int mid)
    {
        int totalHours = 0 ;
        for(int num : piles)
        {
            totalHours  += (num + mid - 1) / mid;
         }
         return totalHours <= h;
        }
     
}
