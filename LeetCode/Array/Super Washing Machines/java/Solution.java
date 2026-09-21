class Solution {
    public int findMinMoves(int[] machines) {
        int c=0,sum=0,no=0,max=0;
        for(int i=0;i<machines.length;i++)
        {
            sum+=machines[i];
        }
        if(sum%machines.length!=0){return -1;}
        else
         no=sum/machines.length;
        for(int i=0;i<machines.length;i++)
        {
            // int d=no-machines[i];
            // if(d>0)
            // {
            //     c=c+d;
            // }
            c= c + machines[i]-no;
            max=Math.max(Math.max(max,Math.abs(c)),machines[i]-no);  //gbt
        }
        return max;
    }
}