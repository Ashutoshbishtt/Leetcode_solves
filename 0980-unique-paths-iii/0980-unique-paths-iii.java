class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zero = 0;
        int x = 0;
        int y = 0;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0) zero++;
                else if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
            }
        }
        
       return dfs(grid,x,y,zero);
        
    }
    
    private int dfs(int grid[][] , int x , int y , int zero){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
            return 0;
        }
        
        if(grid[x][y]==2){
            return zero == -1 ? 1 : 0;
        }
        
        grid[x][y] = -1;
        zero--;
        
        int totalPaths = dfs(grid,x+1,y,zero)+
            dfs(grid,x-1,y,zero)+
            dfs(grid,x,y+1,zero)+
            dfs(grid,x,y-1,zero);
        
        grid[x][y]=0;
        zero++;
        return totalPaths;
    }
}