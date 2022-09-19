class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum=0;
        int n = cardPoints.length;
        
        for(int i = 0 ; i < k ; i++){
            lSum+=cardPoints[i];
        }
        int max=lSum;
        for(int i = 0 , rSum=0 ; i < k ; i++){
            rSum+=cardPoints[n-1-i];
            lSum-=cardPoints[k-i-1];
            
            max=Math.max(lSum+rSum,max);
        }
        return max;
    }
}