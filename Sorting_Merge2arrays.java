/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
and two integers m and n, representing the number of elements in nums1 and nums2 
respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be 
stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
where the first m elements denote the elements that should be merged, and the last
 n elements are set to 0 and should be ignored. nums2 has a length of n.

*/

import java.util.Arrays;

public class Sorting_Merge2arrays {
    public static void main (String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        // int[] nums1 = {0};
        // int[] nums2 = {1};
        // int m = 0;
        // int n = 1;

        merge(nums1, nums2, m, n);

        System.out.println(Arrays.toString(nums1));
    }

    static void merge (int[] nums1, int[] nums2, int m, int n) {
        int[] ans = new int[m+n];

        int ptans = 0;
        int ptm = 0;
        int ptn = 0;

        while (ptm!=m && ptn != n) {
            // System.out.println(ptm + " " + ptn + " " + m + " " + n);
            if (nums1[ptm] > nums2[ptn]) {
                ans[ptans] = nums2[ptn];
                ptn++;
            } else {
                ans[ptans] = nums1[ptm];
                ptm++;
            }
            ptans++;
            // System.out.println(Arrays.toString(nums1));
        }

        if (ptm==m) {
            while ((ptn!=n) && (ptans!=m+n)) {
                // System.out.println(Arrays.toString(nums1));
                ans[ptans] = nums2[ptn];
                ptans++;
                ptn++;
            }
        } else {
            while (ptm != m+n && ptans!=m+n) {
                // System.out.println(Arrays.toString(nums1));
                ans[ptans] = nums1[ptm];
                ptans++;
                ptm++;
                
            }
        }

        // nums1 = Arrays.copyOf(ans, m+n); //This method to copy and array works such that it allocates a new array, copies elements of ans[] and then returns the new array head. 
        System.arraycopy(ans, 0, nums1, 0, m+n); // This copies the source array content into a destination array (that is pre-allocated by user).

    }
} 