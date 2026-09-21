class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int n=s.length();
        int max=0;
        int l=0;
        for(int i=0;i<n;i++){
         char c=s.charAt(i);
         while(set.contains(c)){
            set.remove(s.charAt(l));
            l++;
         }
         set.add(c);
         max=Math.max(max,i-l+1);
        }
        return max;
    }
}