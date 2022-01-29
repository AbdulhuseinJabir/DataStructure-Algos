import java.util.*;

/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

*/
public class Array_threeSum {
    public static void main(String[] args) {
        int [] data = {-1,0,1,2,-1,-4};
        System.out.println(On2(data));
        System.out.println(fastestSolution(data));
    }

    public static List<List<Integer>> fastestSolution(int[] input) {
        
        if (input.length < 3) 
            return new ArrayList<>(); // Handle the edge case
        
        Arrays.sort(input); // Initially sort the array

        List<List<Integer>> result = new ArrayList<>(); // Use the set to remove duplicates

        int i;
        for (i = 0; i < input.length - 2; i++) { // Run through all the numbers given - called Major pointer
            int j = i + 1; // This is the front pointer
            int k = input.length - 1; // This is the end pointer
            while (j < k) { // Keep moving the pointers towards each other and to the center.
                int currSum = input[i] + input[j] + input[k];
                if (currSum > 0) k--; // Move end pointer left
                else if (currSum < 0) j++; // Move front pointer right
                else {
                    while ((j + 1 < input.length - 1) && (input[j] == input[j + 1])) // Use this while loop to keep moving front pointer to the right if values are same - This is to remove duplicates in result
                        j++;
                    while ((k - 1 > j) && (input[k] == input[k - 1])) // Use this while loop to keep moving the end pointer to the left - This is to remove duplicates in result
                        k--;
                    result.add(Arrays.asList(input[i], input[j++], input[k--]));
                }
            }
        }
        while ((i + 1 < input.length - 2) && (input[i] == input[i + 1])) // Move the Major pointer to the right if the values are same - This is to remove duplicates in result
            i++;
        
        return new ArrayList<>(result);
    } 

    public static List<List<Integer>> On2(int[] input) {
        
        if (input.length < 3) 
            return new ArrayList<>();
        
        Arrays.sort(input);
        
        Set<List<Integer>> set = new HashSet<>(); // Use a HashSet in order to do the work of removing the duplicates. This will obviously take more time. 
        
        for (int i = 0; i < input.length - 2; i++) {
            int j = i + 1;
            int k = input.length - 1;
            while (j < k) {
                int currSum = input[i] + input[j] + input[k];
                if (currSum > 0) k--;
                else if (currSum < 0) j++;
                else set.add(Arrays.asList(input[i], input[j++], input[k--]));
            }
        }
        return new ArrayList<>(set);
    }

}

