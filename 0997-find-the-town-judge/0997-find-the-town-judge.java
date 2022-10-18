class Solution {
    public int findJudge(int N, int[][] arr) {
        int[] trust = new int[N];
        int[] trusted = new int[N];
        for(int i = 0; i < arr.length; i++){
            int a = arr[i][0]; 
            int b = arr[i][1];
            trust[a - 1]++;
            trusted[b - 1]++;
        }
        for(int i = 0; i < N; i++){
            if(trust[i] == 0 && trusted[i] == N - 1)
                return i + 1;
        }
        return -1;
    }
}