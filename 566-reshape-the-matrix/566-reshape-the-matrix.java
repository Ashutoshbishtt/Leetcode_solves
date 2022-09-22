class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m*n!=r*c)return mat;
        int[][] ans = new int[r][c];
        int col = 0,row=0;
        
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                ans[row][col] = mat[i][j];
                
                col++;
                if(col==c){
                    col=0;
                    row++;
                }
            }
        }
        return ans;
    }
}