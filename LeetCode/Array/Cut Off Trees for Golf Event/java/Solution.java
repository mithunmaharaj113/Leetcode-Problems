class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.get(0).get(0) == 0) return -1;
        int count = 0;
        int r = forest.size(), c = forest.get(0).size();
        
        // Collect all trees in priority queue sorted by height
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(forest.get(i).get(j) > 1){
                    pq.offer(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        
        int oldr = 0, oldc = 0;
        while(!pq.isEmpty()){
            boolean[][] visited = new boolean[r][c];
            visited[oldr][oldc] = true;
            int[] cell = pq.poll();
            int newr = cell[1], newc = cell[2];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{oldr, oldc});
            int steps = 0;
            boolean found = false;

            loop:
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int[] box = queue.poll();
                    int x = box[0], y = box[1];

                    if(x == newr && y == newc){
                        count += steps;
                        found = true;
                        break loop;
                    }

                    for(int d = 0; d < 4; d++){
                        int X = x + dx[d], Y = y + dy[d];
                        if(X < 0 || X >= r || Y < 0 || Y >= c) continue;
                        if(!visited[X][Y] && forest.get(X).get(Y) > 0){
                            visited[X][Y] = true;
                            queue.add(new int[]{X, Y});
                        }
                    }
                }
                steps++;
            }

            if(!found) return -1;
            oldr = newr;
            oldc = newc;
        }
        
        return count;
    }
}