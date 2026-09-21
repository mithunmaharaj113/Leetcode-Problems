class Solution {
    public int distributeCandies(int[] c) {
    //     int kat=0;
    //     for(int i=0;i<candyType.length;i++){
    //         for(int j=i+1;j<candyType.length;j++){
    //             if(candyType[i]!=candyType[j]){  
    //                 kat++;
    //             }else if(candyType[i]==candyType[j]){
    //                 return 1;
    //             }
    //         }
    //     }
    //    return kat; 
        Set<Integer> set = new HashSet<>();
        int n = c.length;
        for(int i : c) set.add(i);
        if(set.size() < n/2) return set.size();
        else return n/2;
    }
}