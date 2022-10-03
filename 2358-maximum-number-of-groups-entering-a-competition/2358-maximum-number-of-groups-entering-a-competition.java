class Solution {
    public int maximumGroups(int[] grades) {
        int ans = 0, temp = 2, i = 0;
        int n = grades.length;
        while(i < n){
            ans++;
            i += temp;
            temp++;
        }
        return ans;
    }
}