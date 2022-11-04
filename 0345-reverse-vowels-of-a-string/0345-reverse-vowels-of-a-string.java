class Solution {
    public String reverseVowels(String s) {
        int x=0;
        int y=s.length()-1;
        
        List<Character> list = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        
        char[] arr = s.toCharArray();
        while(x<y){
            if(!list.contains(arr[x])){
                x++;
            }if(!list.contains(arr[y])){
                y--;
            }
            if(list.contains(arr[x])&& list.contains(arr[y])){
                char temp = arr[x];
                arr[x]=arr[y];
                arr[y] = temp;
                x++;
                y--;
            }
        }
        return new String(arr);
    }
}