class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        for (int i : nums){
            prefixSum += i;
            count +=map.getOrDefault(prefixSum-k,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }  
        return count;
    }
}