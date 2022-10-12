class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] s = sentence.split(" ");
        for(String ss : s){
            for(String sss : dictionary){
                if(ss.startsWith(sss)){ss = sss;}
            }
            sb.append(ss).append(" ");
        }
        return sb.toString().trim();
    }
}