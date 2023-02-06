class Solution {
    public int[] shuffle(int[] nums, int n) {
        int left=0,mid=n;
        int b[]= new int[2*n];
        for(int i=0;i<2*n;i=i+2)
        {
            b[i] = nums[left++];
            b[i+1] = nums[mid++];
        }
        return b;
    }
}