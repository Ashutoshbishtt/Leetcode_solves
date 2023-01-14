class Solution {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder ans = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            ans.append(uf.get(c - 'a'));
        }
        return ans.toString();
    }

    class UnionFind {
        int[] parents;

        UnionFind() {
            this.parents = new int[26];
            for (int i = 0; i < 26; i++) {
                this.parents[i] = i;
            }
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        void union(int x, int y) {
            int xx = find(x);
            int yy = find(y);
            if (xx < yy) {
                parents[yy] = xx;
            } else {
                parents[xx] = yy;
            }
        }

        char get(int x) {
            return (char) ('a' + find(x));
        }
    }
}
