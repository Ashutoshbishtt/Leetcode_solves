class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = 0;
        
        int pre = bottom-1;
        int n = special.length;
        for(int it : special){
            ans = Math.max(ans,it-pre-1);
            pre = it;
        }
        ans = Math.max(ans , top-special[n-1]);
        return ans;
    }
}