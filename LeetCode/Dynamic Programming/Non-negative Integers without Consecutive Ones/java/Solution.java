class Solution {
    
    int cnt = 2;
    
    public int findIntegers(int n) {
        
        dfs(1, 1, n);
        return cnt;
    }
    
    public void dfs(int prev, int num, int n){
        
        if(num*2 <= n){
            cnt++;
            dfs(0, num*2, n);
        }
        
        if(prev == 0 && num*2+1 <= n){
            cnt++;
            dfs(1, num*2+1, n);
        }
    }
}