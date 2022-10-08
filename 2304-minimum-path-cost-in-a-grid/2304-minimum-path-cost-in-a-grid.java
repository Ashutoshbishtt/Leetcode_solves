class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        
        int cost[][] = new int[m][n];
        for(int c = 0 ; c < n ; c++){
            cost[0][c] = grid[0][c];
        }
        
        for(int r = 1 ; r < m ; r++){
            for(int c = 0 ; c < n ; c++){
                int costFromPreviousRow = Integer.MAX_VALUE;
                
                for(int j = 0 ; j < n ; j++){
                    costFromPreviousRow = Math.min(costFromPreviousRow,cost[r-1][j]+moveCost[grid[r-1][j]][c]);
                }
                cost[r][c] = costFromPreviousRow + grid[r][c];
            }
        }
        int leastCostInLastRow = Integer.MAX_VALUE;
        for(int el : cost[m-1]){
            leastCostInLastRow = Math.min(leastCostInLastRow,el);
        }
        return leastCostInLastRow;
    }
}