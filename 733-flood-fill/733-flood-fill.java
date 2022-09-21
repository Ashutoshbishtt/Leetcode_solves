class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor==image[sr][sc])return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    
    private void dfs(int[][] image,int row , int col , int color , int oldColor){
        if(row>=image.length || row < 0 || col>=image[0].length || col<0 || image[row][col]!=oldColor)return;
        
        image[row][col] = color;
        
        dfs(image,row-1,col,color,oldColor);
        dfs(image,row+1,col,color,oldColor);
        dfs(image,row,col-1,color,oldColor);
        dfs(image,row,col+1,color,oldColor);
    }
    
}