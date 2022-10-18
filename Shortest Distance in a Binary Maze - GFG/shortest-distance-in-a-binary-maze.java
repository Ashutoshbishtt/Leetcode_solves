//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class tuple{
    int first;
    int second;
    int third;
    tuple(int first, int second , int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0]==destination[0] && source[1]== destination[1])return 0;
        
        Queue<tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int dis[][] = new int[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        dis[source[0]][source[1]]=0;
        q.add(new tuple(0,source[0],source[1]));
        int dirx[]={1,0,-1,0};
        int diry[]={0,1,0,-1};
        while(!q.isEmpty()){
            tuple it = q.peek();
            int ds = it.first;
            int r = it.second;
            int c = it.third;
            q.remove();
            for(int i = 0 ; i < 4 ; i++){
                int newr = r+dirx[i];
                int newc = c+diry[i];
                
                if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1 && ds+1<dis[newr][newc]){
                    dis[newr][newc] = 1+ds;
                    if(newr == destination[0] && newc == destination[1])return ds+1;
                    q.add(new tuple(1+ds,newr,newc));
                }
            }
        }
        return -1;
    }
}

        // Your code here
//         if(source[0] == destination[0] && source[1] == destination[1])return 0;
        
//         Queue<tuple> q = new LinkedList<>();
//         int n = grid.length;
//         int m = grid[0].length;
//         int dis[][] = new int[n][m];
//         for(int i = 0 ; i < n ; i++){
//             for(int j = 0 ; j < m ; j++){
//                 dis[i][j] = Integer.MAX_VALUE;
//             }
//         }
        
//         dis[source[0]][source[1]]=0;
//         q.add(new tuple(0,source[0],source[1]));
//         int dr[] = {-1,0,1,0};
//         int dc[] = {0,1,0,-1};
        
//         while(!q.isEmpty()){
//             tuple it = q.peek();
//             q.remove();
//             int ds = it.first;
//             int r = it.second;
//             int c = it.third;
            
//             for(int i = 0 ; i < 4 ; i++){
//                 int newr = r+dr[i];
//                 int newc = c+dc[i];
                
//                 if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1 && ds+1<dis[newr][newc]){
//                     dis[newr][newc] = 1+ds;
//                     if(newr == destination[0] && newc == destination[1])return ds+1;
//                     q.add(new tuple(1+ds,newr,newc));
//                 }
//             }
//         }
//         return -1;
//     }
// }
