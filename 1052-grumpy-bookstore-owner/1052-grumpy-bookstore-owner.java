class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int max = 0;
        
        for(int i = 0 , extra=0; i<grumpy.length ; i++){
            if(grumpy[i]==0){
                res+=customers[i];
            }else{
                extra+=customers[i];
            }
            
            if(i>=minutes && grumpy[i-minutes]==1){
                extra-=customers[i-minutes];
            }
            max=Math.max(max,extra);
        }
        return max+res;
    }
}