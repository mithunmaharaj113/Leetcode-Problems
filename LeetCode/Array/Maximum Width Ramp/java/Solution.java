class Solution {
    public int maxWidthRamp(int[] nums) {

        int n = nums.length;

        // maximum element from i to n-1
        int[] maxRight = new int[n];

        maxRight[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(nums[i], maxRight[i + 1]);
        }

        int left = 0;
        int right = 0;

        int ans = 0;

        while (left < n && right < n) {

            // Ramp is possible
            if (nums[left] <= maxRight[right]) {

                ans = Math.max(ans, right - left);

                right++;
            }

            // Ramp impossible
            else {

                left++;
            }
        }

        return ans;
    }
}