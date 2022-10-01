class Solution {

    public boolean equalFrequency(String word) {
      int count[]=new int[26];
        
        for(char ch:word.toCharArray()){
            count[ch-'a']++;
        }
        
        
        
        Arrays.sort(count);
        int cp[]=count.clone();
        count[25]--;
        
        Arrays.sort(count);
        
        int eq=count[25];
        
         boolean check=false;
        for(int num:count){
            if(num==0) continue;
            
            if(num!=eq) {
                check=true;
                break;
            }
        }
        
       if(check){
        for(int i=0; i<26; i++){
            if(cp[i]==0) continue;
            
            eq=i; 
            break;
        }
        
        cp[eq]--;
        
        Arrays.sort(cp);
        
        
        eq=cp[25];
        
        
        for(int num:cp){
            if(num==0) continue;
            
            if(num!=eq) return false;
        }
       }
        return true;
        
    }
}