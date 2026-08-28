class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        // arry to store frequency of each character .

        int left =0  , maxFreq=0 , maxLen = 0;

        for(int right = 0 ; right < s.length() ; right++)
        // iterate from zero to find substring
        {
            char c = s.charAt(right); // store each charcer by character

            freq[c-'A']++;   // store freqency
            maxFreq = Math.max(maxFreq , freq[c-'A']);

            while((right - left + 1)- maxFreq > k)
            {
                freq[s.charAt(left) - 'A' ]--;
                left++;


            } 

            maxLen = Math.max(maxLen , right - left + 1);
        }
        return maxLen;
    }
}
