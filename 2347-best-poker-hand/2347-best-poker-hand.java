class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int max = 0, suit = 0;
        char ch = suits[0];

        int[] arr = new int[14];
        for(int i=0; i<ranks.length; i++){
            arr[ranks[i]]++;
            max = Math.max(max, arr[ranks[i]]);
            if(suits[i] == ch) suit++;
        }

        if(suit==5) return "Flush";
        return max >= 3 ? "Three of a Kind" : (max == 2 ? "Pair" : "High Card");
    }
}