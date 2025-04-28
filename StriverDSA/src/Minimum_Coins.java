import java.util.*;

class Minimum_Coins {
    public int MinimumCoins(int[] coins, int amount) {

        // greedy approach - use max denomination coins first which are
        // smaller than amount

        int n = coins.length;

        List<Integer> result = new ArrayList<>();

        for (int i=n-1;i>=0;i--) {
            // if amount is equal to coin[i], then that coin can also be used. Hence equal to condition
            while(amount >= coins[i]) {
                amount -= coins[i];
                result.add(coins[i]);
            }
        }

        if (amount == 0) {
            return result.size();
        } else {
            return -1;
        }

    }

    public static void main(String args[]) {
        int[] coins = {1,2,5,10,20,50,100,200,500,2000};
        int amount = 11;

        Minimum_Coins minimumCoins = new Minimum_Coins();

        System.out.println(minimumCoins.MinimumCoins(coins, amount));
    }
}

