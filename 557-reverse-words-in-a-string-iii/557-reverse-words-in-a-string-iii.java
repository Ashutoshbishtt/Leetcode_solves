class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int previousSpaceIndex = -1;
        String ans ="";
        
        
        int i=0;
        for(;i<n;i++){
            if(i==n-1 || s.charAt(i)==' '){
                if(i==n-1){
                    ans +=(reverseWord(s,previousSpaceIndex+1,i+1)+" ");
                }else{
                ans +=(reverseWord(s,previousSpaceIndex+1,i)+" ");
                }
                previousSpaceIndex = i;
            }
        }
        return ans.trim();
    }
     private static String reverseWord(String str,int start,int end){
         String reverse = "";
            while(start < end){
                reverse = str.charAt(start)+reverse;
                ++start;
            }
            return reverse;
        }
}