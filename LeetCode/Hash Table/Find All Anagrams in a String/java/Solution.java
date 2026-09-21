class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> list=new ArrayList<>();
       int l=0;
       int r=0;
       int m=s.length();
       int n=p.length();
       int count=0;
       int freq[] =new int[128];
       for(char c:p.toCharArray()) freq[c]++;
       while(r<m){
        if(freq[s.charAt(r)]>0) count++;
        freq[s.charAt(r)]--;
        if(r-l+1 == n){
            if(count ==n){
                list.add(l);
            }
            freq[s.charAt(l)]++;
            if(freq[s.charAt(l)]>0) count--;
            l++;
        }
        r++;
       } 
       return list;
    }
}
