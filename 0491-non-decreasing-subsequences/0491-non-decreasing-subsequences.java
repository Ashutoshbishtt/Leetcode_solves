class Solution {
    Set<List<Integer>> list;

    public List<List<Integer>> findSubsequences(int[] nums) {
        list = new HashSet<>();
        rec(nums, 0, new ArrayList<>());

        return new ArrayList(list);
    }

    void rec(int[] nums, int curr, List<Integer> temp) {
        if (temp.size() >= 2) {
            list.add(new ArrayList(temp));
        }

        for (int i = curr; i < nums.length; i++) {
            if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
                temp.add(nums[i]);
                rec(nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
