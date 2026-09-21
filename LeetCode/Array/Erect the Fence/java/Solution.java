class Solution {
    public int isGreater(int a[],int b[],int c[]){
        return ((b[0]-a[0])*(c[1]-a[1])-(c[0]-a[0])*(b[1]-a[1])); 

    }
    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        ArrayList<int[]> upper=new ArrayList<>();
        ArrayList<int[]> lower=new ArrayList<>();
        HashSet<int[]> result=new HashSet<>();
      
        for(int i=0;i<trees.length;i++){
            int lastUpper=upper.size()-1;
            int lastLower=lower.size()-1;

            while(upper.size()>=2 && isGreater(upper.get(lastUpper-1),upper.get(lastUpper),trees[i])>0){
                 upper.remove(lastUpper);
                 lastUpper--;
            }
            
            while(lower.size()>=2 && isGreater(lower.get(lastLower-1),lower.get(lastLower),trees[i])<0){
                lower.remove(lastLower);
                lastLower--;
            }
            upper.add(trees[i]);
            lower.add(trees[i]);
        }
        result.addAll(lower);
        result.addAll(upper);
        return result.toArray(new int[result.size()][]);
    }
}