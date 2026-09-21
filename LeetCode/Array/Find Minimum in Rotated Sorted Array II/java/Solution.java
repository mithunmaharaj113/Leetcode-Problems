class Solution {
    public int findMin(int[] nums) {
        
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = (start+end) >>> 1;
            
            if (nums[start]==nums[mid] && nums[mid]==nums[end]){ //It cannot be determined which side is sorted due to duplicates so shrink the search space

                start++;
                end--;
                continue;
            }
            
            if (nums[mid] > nums[end]) {  
                start = mid + 1; // Min lies in the right half
            } 
            else {
                end = mid; // Min lies in the left half
            }
        }

        return nums[start]; 
    }
}