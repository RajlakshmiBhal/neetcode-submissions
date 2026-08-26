class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);  //sort he array so to easily apply two pointer and skip duplicate

        List<List<Integer>> result = new ArrayList<>();  //store the answer

        for ( int i = 0 ; i < nums.length ; i++)    //fix 1st position
        {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //if the next first position is same as previous skip bcoz we dont want duplicate

            int left = i + 1; //left pointer

            int right = nums.length-1 ;   //right pointer

            while (left < right )   //until left become greater than right
            {
                int sum = nums[i] + nums[left] + nums[right];   // sum the values

                if (sum == 0)    // check
                {
                  result.add( Arrays.asList(nums[i] , nums[left] , nums[right]));  //add the list

                  while(left < right && nums[left] == nums[left+1])
                  {
                    left++;   // for the next poingter check if same as previous
                  }
                  while(left < right && nums[right] == nums[right-1])
                  {
                    right --;
                  }
                  left++;   
                  right--;
                }
                else if (sum < 0){   // value less than 0 we need to increase the value so....
                    left++;
                }
                else{
                    right--;    // value more than 0 we need to decrease the value so....
                }
            }

        }
        return new ArrayList<>(result);
        
    }
}
