class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=0;
        int sum=0;  int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++)
        {
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {sum=nums[i]+nums[left]+nums[right];
            if(sum<target)
            {
                left++;
                if(min>target-sum)
                {
                    min=target-sum;
                    ans=sum;
                }
            }
            else{
                if(sum>target)
                {
                    right--;
                    if(min>sum-target)
                    {
                        min=sum-target;
                        ans=sum;
                    }
                }
                else{
                    return sum;
                }
            }}
        }
        return ans;   
    }
}