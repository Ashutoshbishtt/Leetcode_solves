class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[nums.length-1];
        
        for(int i=0;i<nums.length-2;i++){
            int s = i+1,end=nums.length-1;
            
            while(s<end){
                int sum=nums[i]+nums[s]+nums[end];
                if(sum>target){
                    end--;
                }else{
                    s++;
                }
                if(Math.abs(sum-target)<Math.abs(ans-target)){
                    ans=sum;
                }
            }
        }
        return ans;
        
    }
}