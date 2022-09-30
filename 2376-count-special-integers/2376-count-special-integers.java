class Solution {
    public int countSpecialNumbers(int n) {
        String sn = "" + n;
        int len = sn.length();
        if(len == 1)
            return n;
        int[] d = new int[len];
        for(int i = 0; i < len; i++)
            d[i] = (int)(sn.charAt(i) - '0');
        
        int res = 0;
        for(int i = 1; i <= len - 1; i++) {
            res += 9 * compute(i);
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < len; i++) {
            if(set.size() < i)
                break;
            
            int c = d[i];
            if(i == 0)
                c--;
            else if(i == len - 1)
                c++;
            
            // System.out.println("c = " + c);
            for(int j = 0; j < i; j++) {
                if(d[i] > d[j])
                    c--;
                else if(d[i] == d[j] && i == len - 1)
                    c--;
            }
                
            
            // System.out.println("c1 = " + c);
            int v = 1;
            if(i + 1 < len) {
                for(int a = 0; a < len - i - 1; a++) {
                    v *= (9 - i - a);
                }
            }
            res += c * v;
            // System.out.println("res = " + res);
            
            set.add(d[i]);
        }
        return res;
    }
    
    private int compute(int i) {
        int v = 1;
        int s = 9;
        for(int k = 0; k < i - 1; k++) {
            v *= s;
            s--;
        }
        return v;
    }
}