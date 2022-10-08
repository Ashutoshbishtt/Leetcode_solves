class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int array1M = 0;
        int array2M = 0;
        int diff[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            array1M+=nums1[i];
            array2M+=nums2[i];
        }
        
        for(int i = 0 ; i < n ; i++){
            diff[i] = nums2[i]-nums1[i];
        }
        
        int max=0,cur=0;
        for(int el : diff){
            cur=Math.max(cur+el,el);
            max=Math.max(max,cur);
        }
        
        array1M+=max;
        
        for(int i = 0 ; i < n ; i++){
            diff[i] = nums1[i] - nums2[i];
        }
        
        max=0;
        cur = 0;
        for(int el : diff){
            cur = Math.max(cur+el,el);
            max=Math.max(max,cur);
        }
        array2M+=max;
        return Math.max(array1M,array2M);
    }
}