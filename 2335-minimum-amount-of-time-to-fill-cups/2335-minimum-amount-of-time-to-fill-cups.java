class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int x = amount[0];
        int y = amount[1];
        int z = amount[2];
        if(x + y > z) return (x + y + z) / 2 + (x + y + z) % 2;
        return z;
    }
}