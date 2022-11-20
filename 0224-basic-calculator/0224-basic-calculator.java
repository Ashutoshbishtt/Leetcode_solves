class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i = 0 ,sign=1; i < s.length() ; i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i)-'0';
                for(;i<s.length() -1 && Character.isDigit(s.charAt(i+1));i++){
                    num=num*10+(s.charAt(i+1)-'0');
                }
                st.push(st.pop()+sign*num);
            }else if(s.charAt(i)=='+'){
                sign=1;
            }else if(s.charAt(i)=='-'){
                sign=-1;
            }else if(s.charAt(i)=='('){
                st.push(sign);
                st.push(0);
                sign=1;
            }else if(s.charAt(i)==')'){
                st.push(st.pop()*st.pop()+st.pop());
            }
        }
        return st.pop();
    }
}