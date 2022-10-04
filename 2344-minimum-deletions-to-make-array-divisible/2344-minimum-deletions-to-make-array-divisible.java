class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = findGCD(numsDivide);
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if(gcd % nums[i] == 0)return i;
        }
        return -1;
    }
    
    private int findGCD(int[] numsDivide){
        int gcd = numsDivide[0];
        for(int i = 1 ; i < numsDivide.length ; i++){
            int num = numsDivide[i];
            while(num > 0){
                int tmp = gcd % num;
                gcd = num;
                num = tmp;
            }
        }
        return gcd;
    }
}