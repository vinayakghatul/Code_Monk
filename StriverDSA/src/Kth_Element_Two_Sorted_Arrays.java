import java.util.*;

class Kth_Element_Two_Sorted_Arrays {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int i=0,j=0;

        int count =0;

        int result = -1;

        while(i<a.length && j<b.length) {
            if (a[i] < b[j]) {
                result = a[i];
                i++;
                count++;
            } else {
                result = b[j];
                j++;
                count++;
            }

            if (count == k) {
                return result;
            }
        }

        while(i< a.length) {
            result = a[i];
            i++;
            count++;

            if (count == k) {
                return result;
            }
        }

        while(j < b.length) {
            result = b[j];
            j++;
            count++;

            if (count == k) {
                return result;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] a = {1,2,6,8};
        int[] b = {3,5,6,7,9};

        int k = 5;

        Kth_Element_Two_Sorted_Arrays kthElementTwoSortedArrays = new Kth_Element_Two_Sorted_Arrays();

        System.out.println(kthElementTwoSortedArrays.kthElement(a, b, k));
    }
}