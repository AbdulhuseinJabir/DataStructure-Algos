/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayTwoSum {
    public static void main (String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twosum(nums, target)));
    }

    static int[] twosum(int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            int currentVal = nums[i];
            if (map.containsKey(target - currentVal)){
                return (new int[]{i, map.get(target - currentVal)}); //Understand here how to return a new array.
            }
            map.put(currentVal, i);                
        }
        return null;
    }
}