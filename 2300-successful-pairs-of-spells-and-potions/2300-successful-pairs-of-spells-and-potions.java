class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int arr[] = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int start = 0;
            int end = potions.length;

            while (start < end) {
                int mid = start + (end - start) / 2;
                if (spells[i] * 1l * potions[mid] >= success) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            arr[i] = (potions.length - end);
        }
        return arr;
    }
}
