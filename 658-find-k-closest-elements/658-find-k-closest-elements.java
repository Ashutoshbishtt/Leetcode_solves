class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int low = 0;
        int high = arr.length-1;
        
        while(high-low>=k){
            int dL = Math.abs(arr[low]-x);
            int dH = Math.abs(arr[high]-x);
            
            if(dL<=dH){
                high--;
            }else{
                low++;
            }
        }
        while(low<=high)ans.add(arr[low++]);
        return ans;
    }
}