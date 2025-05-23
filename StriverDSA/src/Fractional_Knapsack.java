import java.util.*;

/**
 * roblem Statement: The weight of N items and their corresponding values are given.
 * We have to put these items in a knapsack of weight W such that the total value obtained is maximized.
 *
 * Note: We can either take the item as a whole or break it into smaller units.
 *
 * Example:
 *
 * Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.
 *
 * Output: 240.00
 *
 * Explanation: The first and second items  are taken as a whole
 * while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00
 */

class Fractional_Knapsack {

    class Item {
        int val;
        int wt;

        public Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
    }

    double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n = values.length;

        Item[] items = new Item[n];

        for (int i=0;i<n;i++) {
            items[i] = new Item(values[i], weights[i]);
        }


        // Sort new array in descending order
        Arrays.sort(items, (a,b) -> {
            double r1 = ((double)a.val/a.wt);
            double r2 = ((double)b.val/b.wt);

            // compare descending order
            return Double.compare(r2,r1);
        });

        double totalVal = 0;
        int totalWt = 0;

        for (Item item : items) {
            if (totalWt + item.wt <= W) {
                totalVal = totalVal + item.val;
                totalWt = totalWt + item.wt;
            } else {
                double remainingWt = W - (totalWt);
                totalVal = totalVal + ((double)item.val/item.wt)*remainingWt;
                break;
            }
        }

        return totalVal;

    }

    public static void main(String args[]) {
        int[] values = {60,100,120};
        int[] weights = {10,20,30};

        int W = 50;

        Fractional_Knapsack fractionalKnapsack = new Fractional_Knapsack();

        System.out.println(fractionalKnapsack.fractionalKnapsack(values, weights, W));

    }
}