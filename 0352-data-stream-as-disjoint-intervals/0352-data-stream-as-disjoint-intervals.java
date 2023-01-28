class SummaryRanges {
    TreeMap<Integer, int[]> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if (tree.containsKey(val)) return;

        Integer lowerKey = tree.lowerKey(val);
        Integer higherKey = tree.higherKey(val);

        if (lowerKey != null && higherKey != null && val == tree.get(lowerKey)[1] + 1 && val == tree.get(higherKey)[0] - 1) {
            tree.get(lowerKey)[1] = tree.get(higherKey)[1];
            tree.remove(higherKey);
        } else if (lowerKey != null && val <= tree.get(lowerKey)[1] + 1) {
            tree.get(lowerKey)[1] = Math.max(val, tree.get(lowerKey)[1]);
        } else if (higherKey != null && val == tree.get(higherKey)[0] - 1) {
            tree.put(val, new int[] { val, tree.get(higherKey)[1] });
            tree.remove(higherKey);
        } else { // Case 1
            tree.put(val, new int[] { val, val });
        }
    }

    public int[][] getIntervals() {
        return tree.values().toArray(new int[tree.size()][2]);
    }
}
