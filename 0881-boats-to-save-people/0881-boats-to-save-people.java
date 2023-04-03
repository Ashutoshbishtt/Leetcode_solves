class Solution {

    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int low = 0, right = people.length - 1;

        while (low <= right) {
            int sum = people[low] + people[right];
            if (sum <= limit) {
                boat++;
                right--;
                low++;
            } else {
                boat++;
                right--;
            }
        }
        return boat;
    }
}
