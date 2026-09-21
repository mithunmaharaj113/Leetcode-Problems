class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new  ArrayList <>();
        sub(0,nums,ans,new ArrayList<>());
        return ans;
    }
    public static void sub(int index ,int nums[],List<List<Integer>> ans,List<Integer>temp){
    if(index == nums.length){
        ans.add(new ArrayList<>(temp));
        return;
    }
    temp.add(nums[index]);
    sub(index+1,nums,ans,temp);
    temp.remove(temp.size()-1);
    sub(index+1,nums,ans,temp);
    }
    
}