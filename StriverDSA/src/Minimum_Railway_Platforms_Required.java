import java.util.*;

public class Minimum_Railway_Platforms_Required {

    public int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int maxSoFar = Integer.MIN_VALUE;
        int count = 0;
        int n = Arrival.length;

        int j = 0;
        int i = 0;

        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                i++;
                count++;
                maxSoFar = Math.max(count, maxSoFar);
            } else {
                j++;
                count--;
            }
        }

        System.out.println(maxSoFar);
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] Arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] Departure = {910, 1200, 1120, 1130, 1900, 2000};

        Minimum_Railway_Platforms_Required obj = new Minimum_Railway_Platforms_Required();
        obj.findPlatform(Arrival, Departure);
    }
}
