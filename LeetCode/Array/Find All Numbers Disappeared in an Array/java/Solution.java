class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer>pandya=new ArrayList<>();
      for(int i=0;i<nums.length;i++){
        int index=Math.abs(nums[i])-1;
        if(nums[index]>0){
        nums[index]=-nums[index];
        }
      }  
    for(int i=0;i<nums.length;i++){
    if(nums[i]>0){
      pandya.add(i+1);   
    }
    }
    return pandya;
  }
}