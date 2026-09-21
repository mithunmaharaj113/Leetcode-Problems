class Solution {
    class Pair { // to store coordinates
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left

    public void bfs(char[][] grid, Queue<Pair> q){
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            
            // explore all neighbours
            for(int d=0; d<4; d++){
                int ni = i + dir[d][0];
                int nj = j + dir[d][1];
                
                if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj]=='O'){
                    grid[ni][nj] = 'T'; // temporarily mark as 'T'
                    q.add(new Pair(ni, nj));
                }
            }
        }
    }

    public void solve(char[][] board) {

        // 1. Pehle boundary pr jo O h use traverse(as graph) krke mark krdo 'T'
        // 2. Firr jo 'O' abhi bhi bache h wo boundary se connected nahi h use 'X' mark krdo
        // 3. Again jinhe 'T' mark kiya tha use wapas se 'O' kardo

        int n = board.length;
        int m = board[0].length;
        
        Queue<Pair> q = new LinkedList<>(); // for bfs
        
        // traverse all boundary row cells
        for(int i=0; i<n; i++){
            if(board[i][0]=='O'){
                q.add(new Pair(i, 0)); // add in q for bfs
                board[i][0] = 'T'; // temporarily mark as 'T'
            }
            if(board[i][m-1]=='O'){
                q.add(new Pair(i, m-1)); // add in q for bfs
                board[i][m-1] = 'T'; // temporarily mark as 'T'
            }
        }

        // traverse all boundary column cells
        for(int j=0; j<m; j++){
            if(board[0][j]=='O'){
                q.add(new Pair(0, j)); // add in q for bfs
                board[0][j] = 'T'; // temporarily mark as 'T'
            }
            if(board[n-1][j]=='O'){
                q.add(new Pair(n-1, j)); // add in q for bfs
                board[n-1][j] = 'T'; // temporarily mark as 'T'
            }
        }

        // BFS traversal from all boundary 'O's
        bfs(board, q);
        
        // flip surrounded regions and restore boundary-connected ones
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O'){ // fill all 'O' places to 'X'
                    board[i][j] = 'X';
                } else if(board[i][j]=='T'){
                    // change the temporary mark to original 'O'
                    board[i][j] = 'O';
                }
            }
        }
    }
}
