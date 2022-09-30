class Solution {
    public int edgeScore(int[] edges) {
        HashMap<Integer,Integer> map  = new HashMap<>();
        int highestScoreNode = 0;
        
        for(int i = 0 ; i < edges.length ; i++){
            map.put(edges[i],map.getOrDefault(edges[i],0)+i);
            int lastScore = map.get(edges[i]);
            int highestScore = map.getOrDefault(highestScoreNode,0);
            if(lastScore>highestScore){
                highestScoreNode = edges[i];
            }else if(highestScore == lastScore){
                highestScoreNode = Math.min(edges[i],highestScoreNode);
            }
        }
        return highestScoreNode;
    }
}