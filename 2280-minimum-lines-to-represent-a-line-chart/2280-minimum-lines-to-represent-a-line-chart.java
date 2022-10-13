class Solution {
    public int minimumLines(int[][] sp) {
        Arrays.sort(sp,(a,b)->a[0]-b[0]);
        int n = sp.length;
        if(n==1)return 0;
        int cnt = 1;
        for(int i = 0 ; i+2 < n ; i++){
            int xx1 = sp[i+1][0] - sp[i][0];
            int xx2 = sp[i+2][0] - sp[i+1][0];
            int yy1 = sp[i+1][1] - sp[i][1];
            int yy2 = sp[i+2][1] - sp[i+1][1];
            
            if(yy2*xx1 != yy1*xx2)cnt++;
        }
        return cnt;
    }
}