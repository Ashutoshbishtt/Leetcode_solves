class Solution {
    public int longestSubstring(String s, int k) {
        int freq[] = new int[26];
        int res = 0;
        int start = 0;
        
        for(int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i)-'a']++;
        }
        
        boolean valid=true;
        
        for(int end = 0 ; end < s.length() ; end++){
            if(freq[s.charAt(end)-'a']<k){
                res = Math.max(res,longestSubstring(s.substring(start,end),k));
                valid = false;
                start=end+1;
            }
        }
        return valid ? s.length() : Math.max(res,longestSubstring(s.substring(start),k));
    }
}