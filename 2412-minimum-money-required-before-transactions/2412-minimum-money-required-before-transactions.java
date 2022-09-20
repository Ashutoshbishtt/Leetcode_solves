class Solution {
    public long minimumMoney(int[][] transactions) {
        Arrays.sort(transactions,(int a[],int b[])->(a[1]-b[1]));
        long max=0,ans=0,a=0;
        for(int it[] : transactions){
            if(it[0]>it[1]){
                max+=it[0];
                ans=Math.max(ans,max);
                max-=it[1];
            }else{
                a = Math.max(a,it[0]);
            }
        }
        ans=Math.max(ans,max+a);
        return ans;
    }
}