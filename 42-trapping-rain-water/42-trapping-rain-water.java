class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];
        
        maxLeft[0]=arr[0];
        
        for(int i=1;i<n;i++){
            maxLeft[i]=Math.max(arr[i],maxLeft[i-1]);
        }
        
        maxRight[n-1]=arr[n-1];
        
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(arr[i],maxRight[i+1]);
        }
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=Math.min(maxRight[i],maxLeft[i])-arr[i];
        }
        return sum;
    } 
}
