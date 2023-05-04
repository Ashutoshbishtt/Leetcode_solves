class Solution {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qD = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                qR.add(i);
            } else {
                qD.add(i);
            }
        }

        while (!qR.isEmpty() && !qD.isEmpty()) {
            int indexR = qR.remove();
            int indexD = qD.remove();
            if (indexR < indexD) {
                qR.add(indexR + n);
            } else {
                qD.add(indexD + n);
            }
        }

        return qR.isEmpty() ? "Dire" : "Radiant";
    }
}
