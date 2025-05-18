import java.util.*;

//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

class Missing_Repeating_Number {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;

        int sumN = n*(n+1)/2;
        int sqSumN = n*(n+1)*(2*n+1)/6;

        int actualSum = 0;
        int actualSqSum = 0;


        for (int i=0;i<n;i++) {
            actualSum = actualSum + arr[i];
            actualSqSum = actualSqSum + (arr[i]*arr[i]);
        }

        // x-y
        int diff = sumN - actualSum;

        // x^2-y^2
        int sqDiff = sqSumN - actualSqSum;

        // x+y = x^2-y^2/x-y
        int temp = sqDiff/diff;

        int missing = (temp + diff)/2;
        int repeat = (temp - diff)/2;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeat);
        result.add(missing);

        return result;

    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 2, 4};
        Missing_Repeating_Number missingRepeatingNumber = new Missing_Repeating_Number();
        System.out.println(missingRepeatingNumber.findTwoElement(arr));
    }
}
