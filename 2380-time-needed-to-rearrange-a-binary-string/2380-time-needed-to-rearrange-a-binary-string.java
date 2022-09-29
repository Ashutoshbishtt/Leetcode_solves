class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int sec = 0;
        while(s.indexOf("01")>=0){
            s=s.replace("01","10");
            sec++;
        }
        return sec;
    }
}