class Solution {
    public int largestCombination(int[] candidates) {
        int res = 0;
        int cur = 0;
        for(int i = 1 ; i <= 100000000 ; i<<=1){
            cur = 0; 
            for(int a : candidates)
                if((a&i)>0)cur++;
            res = Math.max(res,cur);
        }
        return res;
    }
}