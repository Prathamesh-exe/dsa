// https://leetcode.com/problems/gas-station/description/

public class GasStation {
    public static void main(String[] args) {
        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas1, cost1)); // 3
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If currentGas drops below 0, we cannot reach station i+1 from startingStation
            if (currentGas < 0) {
                startingStation = i + 1; // Move starting station to the next station
                currentGas = 0;          // Reset currentGas for the new starting station
            }
        }

        // If total gas is less than total cost, it's impossible to complete the circuit
        return totalGas < totalCost ? -1 : startingStation;
    }
}
