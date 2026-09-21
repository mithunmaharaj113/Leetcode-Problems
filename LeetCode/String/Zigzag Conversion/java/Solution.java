class Solution {
    public String convert(String s, int numRows) {
     int arr[] = new int[s.length()];
     StringBuilder sb =new StringBuilder();
     int ind=0;
     while(ind<s.length()){
        for(int i=1;i<= numRows && ind < s.length();i++){
            arr[ind++]=i;
        }
        for(int i= numRows-1;i>=2 && ind < s.length();i--){
            arr[ind++]=i;
     }  
    }
    for(int i=1;i<= numRows;i++){
        for(int j=0;j<s.length();j++){
            if(arr[j]==i) sb.append(s.charAt(j));
        }
}
return sb.toString();
    }
    }