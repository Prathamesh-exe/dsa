// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

public class CapacityToShipInDDays {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    private static int shipWithinDays(int[] weights, int D) {
        int minCapacity = 0;
        int maxCapacity = 0;
        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }
        while (minCapacity < maxCapacity) {
            int mid = minCapacity + (maxCapacity - minCapacity) / 2;
            int days = 1;
            int sum = 0;
            for (int weight : weights) {
                sum += weight;
                if (sum > mid) {
                    days++;
                    sum = weight;
                }
            }
            if (days > D) {
                minCapacity = mid + 1;
            } else {
                maxCapacity = mid;
            }
        }
        return minCapacity;
    }
}
