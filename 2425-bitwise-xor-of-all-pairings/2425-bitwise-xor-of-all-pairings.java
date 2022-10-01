class Solution
{
  public int xorAllNums (int[]nums1, int[]nums2)
  {
    int res = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 % 2 == 1){
            for(int i = 0; i < n1; i++){
                res ^= nums1[i];
            }
        }
        if(n1 % 2 == 1){
            for(int i = 0; i < n2; i++){
                res ^= nums2[i];
            }
        }
        return res;
    }
}