class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum =0;
        long newSum=0;
        long ans=Integer.MAX_VALUE;
        long index=-1;
        
        
        for(int i = 0 ; i < nums.length ; i++){
            sum+=nums[i];
        }
        
        for(int i = 0 ; i < nums.length ; i++){
            sum=sum-nums[i];
            newSum+=nums[i];
            
            long al=0;
            if(i==nums.length-1){
                al=newSum/nums.length;
            }else{
                al=Math.abs((newSum/(i+1))-(sum/(nums.length-i-1)));
            }
            
            if(al<ans){
                ans=al;
                index=i;
            }
        }
        return (int)index;
    }
}