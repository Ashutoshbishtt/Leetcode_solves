class Solution {

    public double average(int[] salary) {
        double sum = 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i : salary) {
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return (sum - min - max) / (salary.length - 2);
    }
}
