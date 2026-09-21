class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean arr[]=new boolean[26];
        int n=sentence.length();
        int count=0;
        for(int i=0;i<n;i++){
            char c=sentence.charAt(i);
            int index=c-'a';
            if(arr[index]==false){
                arr[index]=true;
                count++;
            }
        }
        if(count==26){
            return true;
        }
        return false;
    }
}