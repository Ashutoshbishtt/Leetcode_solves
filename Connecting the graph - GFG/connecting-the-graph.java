//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static class Disjoint{
        List<Integer> parent=new ArrayList<>();
        List<Integer> size=new ArrayList<>();
        
        public Disjoint(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        
        public int findUParent(int node){
            if(parent.get(node)==node)return node;
            int ulp=findUParent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        
        
        public void unionBySize(int u,int v){
            int ulp_u=findUParent(u);
            int ulp_v=findUParent(v);
            
            if(ulp_u==ulp_v) return;
            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            }else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }

    public int Solve(int n, int[][] edge) {
        // Code here
        Disjoint ds=new Disjoint(n);
        int countExtraEdges=0;
        int m=edge.length;
       for (int i=0;i<m;i++){
             int u=edge[i][0];
             int v=edge[i][1];
             if(ds.findUParent(u)==ds.findUParent(v)){
                 countExtraEdges++;
             }else{
                 ds.unionBySize(u,v);
             }
         }
         int countNumberofComponent=0;
         for(int i=0;i<n;i++){
             if(ds.parent.get(i)==i) countNumberofComponent++;
         }
         int ans=countNumberofComponent-1;
         if(countExtraEdges>=ans)
             return ans;
         return -1;
    }
}