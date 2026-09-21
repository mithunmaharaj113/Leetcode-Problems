/**
 * Sliding Window solution using Buckets
 *
 * Time Complexity: O(N)
 * Space Complexity: O(min(N, K+1))
 *
 * N = Length of input array. K = Input difference between indexes.
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }

        HashMap<Long, Long> buckets = new HashMap<>();
        long bucketSize = (long) t + 1;

        for (int i = 0; i < nums.length; i++) {
            // Remove element out of window
            if (i > k) {
                long lastBucket = ((long) nums[i - k - 1] - Integer.MIN_VALUE) / bucketSize;
                buckets.remove(lastBucket);
            }

            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / bucketSize;

            // Same bucket => within t range
            if (buckets.containsKey(bucket)) {
                return true;
            }

            // Check adjacent buckets for near-boundary cases
            if (buckets.containsKey(bucket - 1) && remappedNum - buckets.get(bucket - 1) <= t) {
                return true;
            }
            if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - remappedNum <= t) {
                return true;
            }

            // Add to bucket
            buckets.put(bucket, remappedNum);
        }

        return false;
    }
}