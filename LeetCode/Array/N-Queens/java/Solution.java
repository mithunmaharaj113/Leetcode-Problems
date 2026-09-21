class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans =new ArrayList<>();
        char[][] board=new char[n][n];
        for(char ch[]:board){
            Arrays.fill(ch,'.');
        }
        solve(0,board,ans,n);
         return ans; 
    }
    public void solve(int col,char[][] board,List<List<String>> ans,int n){
        if(col==n){
            ArrayList<String> temp= new ArrayList<>();
            for(char c[]:board){
                StringBuilder sb=new StringBuilder();
                for(char ch:c){
                    sb.append(ch);
                }
                temp.add(sb.toString());
            }
            ans.add(new ArrayList<>(temp));
            return;
           }
           for(int row=0;row<n;row++){
            if(isValid(row,col,board)){
                board[row][col]='Q';
                solve(col+1,board,ans,n);
                board[row][col]='.';
            }
           }
        }
    
    public boolean isValid(int row,int col,char[][]board){
        int r=row;
        int c=col;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q')return false;
            r--;
            c--;
        }
        r=row;
        c=col;
        while(c>=0){
            if(board[r][c]=='Q')return false;
            c--;
        }
        r=row;
        c=col;
        while(r<board.length&&c>=0){
            if(board[r][c]=='Q')return false;
            r++;
            c--;
        }
        return true;
    }
}