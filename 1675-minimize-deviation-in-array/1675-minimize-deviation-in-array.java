class Solution {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i % 2 == 1) i *= 2;

            pq.add(i);
            min = Math.min(min, i);
        }

        int diff = Integer.MAX_VALUE;

        while (pq.peek() % 2 == 0) {
            int max = pq.remove();
            diff = Math.min(diff, max - min);

            max /= 2;
            min = Math.min(min, max);
            pq.add(max);
        }

        return Math.min(diff, pq.peek() - min);
    }
}
