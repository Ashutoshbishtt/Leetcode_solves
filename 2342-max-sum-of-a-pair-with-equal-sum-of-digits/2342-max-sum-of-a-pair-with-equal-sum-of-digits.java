class Solution {
    private int getDigitSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            int digitSum = getDigitSum(nums[i]);
            
            if(map.containsKey(digitSum)){
                int value = map.get(digitSum);
                max=Math.max(max,value+nums[i]);
                map.put(digitSum,Math.max(nums[i],map.get(digitSum)));
            }else{
                int val = nums[i];
                map.put(digitSum,val);
            }
        }
        return max==Integer.MIN_VALUE ? -1 : max;
        
    }
}