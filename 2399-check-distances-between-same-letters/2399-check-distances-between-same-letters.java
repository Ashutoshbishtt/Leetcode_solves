class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for(int i = 0 ; i < s.length() ; i++){
            int dis = distance[s.charAt(i)-'a'];
            if(i+dis+1<s.length() && s.charAt(i+dis+1)==s.charAt(i)){
                continue;
            }else if(i-dis-1>=0){
                if(s.charAt(i-dis-1)==s.charAt(i)){
                    continue;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}