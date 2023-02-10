class Solution {
    public int maxDistance(int[][] matrix) {
      Queue<int[]> queue = new LinkedList<>();
      int[][] directions = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
      int m = matrix.length;
      int n = matrix[0].length;
      int max = Integer.MIN_VALUE; 
      for(int i = 0; i < m; i++)
          for(int j = 0; j < n; j++)
              if(matrix[i][j] == 1){ 
                  matrix[i][j] = 0; 
                  queue.add(new int[]{i,j});
              }
              else
                  matrix[i][j] = Integer.MIN_VALUE; 

      while(!queue.isEmpty()){
          int[] pos = queue.poll();
          for(int[] dir: directions){
              int x = pos[0] + dir[0];
              int y = pos[1] + dir[1];
              if( x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] < 0){ 
                  queue.add(new int[]{x,y});
                  matrix[x][y] = matrix[pos[0]][pos[1]] + 1;
                  max = Math.max(max , matrix[x][y]);
              }
          }
      }
      return max == Integer.MIN_VALUE ? -1 : max;
    }
}