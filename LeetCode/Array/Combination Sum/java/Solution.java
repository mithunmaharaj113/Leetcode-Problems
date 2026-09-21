class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        sub(0, nums ,target,ans,new ArrayList<>());
        return ans;
    }
    public static void sub(int index,int nums[],int target,List<List<Integer>> ans,List<Integer>temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        if(target < 0) return;
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            sub(i,nums,target-nums[i],ans,temp);
            temp.remove(temp.size()-1);
        }
    }
}