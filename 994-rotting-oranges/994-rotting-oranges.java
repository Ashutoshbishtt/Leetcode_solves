class Solution {
    private class Pair{
        int x;
        int y;
        int t;
        Pair(int x , int y , int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int freshCount = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)freshCount++;
            }
        }
        
        int tm = 0;
        int rowt[] = {-1,0,+1,0};
        int colt[] = {0,-1,0,+1};
        int count = 0;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int t = q.peek().t;
            q.remove();
            
            tm=Math.max(tm,t);
            
            for(int i = 0 ; i < 4 ; i++){
                int nr = x+rowt[i];
                int nc = y+colt[i];
                
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && vis[nr][nc]==0 && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    count++;
                }
            }
        }
        
        if(count!=freshCount)return -1;
        return tm;
        
    }
}