class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Sort by frequency (descending)
        List<Integer> list = new ArrayList<>(freq.keySet());
        list.sort((a, b) -> freq.get(b) - freq.get(a));

        // Step 3: Pick top k
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
