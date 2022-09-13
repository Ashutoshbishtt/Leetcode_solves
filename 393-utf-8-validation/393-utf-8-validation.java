class Solution {
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) return true; 
        for(int i = 0; i < data.length;){
            int next = checkUTF(data,i);
            if(next == -1){
                return false;
            }
            i = next;
        }
        return true;
    }
	
    public int checkUTF(int[] data, int position){
        int allOne = helper(data[position]);
        if(allOne == 0) return position + 1;
        if(allOne >= 5 || allOne == 1) return -1; 
		
        int i = position + 1;
        for(; i < data.length && i < allOne + position;i++){
            int curr = helper(data[i]);
            if(curr != 1) break;
        }
        
        if(allOne + position == i){
            return i ;
        }
        return -1; 
    }
    
    public int helper(int num){
        int result = 0; 
        for(int i = 7; i >=0; i-- ){
            if(((num >> i) & 1) == 1){
                result = 8 - i; 
            }else{
                return result; 
            }
        }
        return result; 
    }
}