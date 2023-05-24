class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;++i){
            arr[i] = new int[]{nums1[i],nums2[i]};
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum =0, ans =0;
        for(int i=0;i<n;++i){
            q.offer(arr[i][0]);
            sum+=arr[i][0];
           
            if(i>=k){
                sum-=q.poll();
            }
            if(i>=k-1){
                ans= Math.max(ans,sum*arr[i][1]);
            }
        }
        return ans;
    }
}