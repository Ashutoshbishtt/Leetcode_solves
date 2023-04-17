class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) max = Math.max(c, max);
        List<Boolean> output = new ArrayList(candies.length);
        for (int c : candies) output.add(c + extraCandies >= max);
        return output;
    }
}
