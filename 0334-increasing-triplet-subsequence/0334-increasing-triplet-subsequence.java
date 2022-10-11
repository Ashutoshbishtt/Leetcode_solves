class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstBig = Integer.MAX_VALUE;
        int secondBig = Integer.MAX_VALUE;
        
        for(int num : nums){
            if(num<=firstBig){
                firstBig=num;
            }else if(num<=secondBig){
                secondBig = num;
            }else{
                return true;
            }
        }
        return false;
    }
}