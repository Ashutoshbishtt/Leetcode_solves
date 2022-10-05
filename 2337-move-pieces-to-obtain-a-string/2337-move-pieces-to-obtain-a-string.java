class Solution {
    public boolean canChange(String start, String target) {
        int i = 0;
        int j = 0;
        
        int n = target.length();
        
        while(i<n || j<n){
            while(i<n && target.charAt(i)=='_')i++;
            while(j<n && start.charAt(j)=='_')j++;
            
            if(i==n || j==n){
                return i==n && j==n;
            }
            
            if(target.charAt(i)!=start.charAt(j))return false;
            
            if(target.charAt(i)=='L'){
                if(j<i)return false;
            }else{
                if(i<j)return false;
            }
            i++;
            j++;
        }
        return true;
    }
}