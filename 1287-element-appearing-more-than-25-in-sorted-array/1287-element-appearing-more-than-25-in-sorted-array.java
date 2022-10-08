class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int one4th = n/4;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i]==arr[i+one4th])return arr[i];
        }
        return -1;
    }
}