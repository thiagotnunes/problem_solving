package searching.examples.exercise_12;

import util.Pair;

/**
 * Maximize profit between buying and selling stocks
 */
public class Solution {

    /**
     * Brute force approach
     * Time complexity - O(n^2)
     * Space complexity - O(1)
     */
    public Pair solve1(int[] array) {
        int buyOn = Integer.MIN_VALUE;
        int sellOn = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            int buyPrice = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int sellPrice = array[j];
                int profit = sellPrice - buyPrice;

                if (profit > maxProfit) {
                    maxProfit = profit;
                    buyOn = i;
                    sellOn = j;
                }
            }
        }

        return new Pair(buyOn, sellOn);
    }

    /**
     * Keep track of lowest buy price
     * Time complexity - O(n)
     * Space complexity - O(1)
     */
    public Pair solve2(int[] array) {
        int curMin = Integer.MIN_VALUE;
        int buyOn = Integer.MIN_VALUE;
        int sellOn = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < curMin) {
                curMin = array[i];
            }

            int profit = array[i] - array[curMin];
            if (profit > maxProfit) {
                maxProfit = profit;
                buyOn = curMin;
                sellOn = i;
            }
        }

        return new Pair(buyOn, sellOn);
    }
}
