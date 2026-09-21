class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int l= 0;
       int r=0;
       int n =nums.length;
       int sum=0;
       double max = Double.NEGATIVE_INFINITY;
       while(r<n){
        sum+=nums[r];
        if(r-l+1 == k){
            double avg = (double) sum/k;
            sum-=nums[l];
            max = Math.max(avg,max);
            l++;
        }
        r++;
       } 
       return max;
    }
}
