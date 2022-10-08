class Solution {
    public boolean judgeCircle(String moves) {
        int U = 2 , D = -2 , L = -2 , R=2;
        int upDown=0;
        int rightLeft=0;
        for(int i = 0 ; i < moves.length() ; i++){
            if(moves.charAt(i)=='U'){
                upDown+=U;
            }else if(moves.charAt(i)=='D'){
                upDown+=D;
            }else if(moves.charAt(i)=='L'){
                rightLeft+=L;
            }else{
                rightLeft+=R;
            }
        }
        if(rightLeft==0 && upDown==0)return true;
        return false;
    }
}