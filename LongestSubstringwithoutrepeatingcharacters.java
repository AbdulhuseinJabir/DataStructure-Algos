/*
Given a string s, find the length of the longest substring without repeating characters.
*/


import java.util.*;

public class LongestSubstringwithoutrepeatingcharacters {
    public static void main(String[] args) {
        
        System.out.println(On("abcabcbb"));
        System.out.println(On2("bbbbbbbb"));
        System.out.println(On3("pwwkew"));
        // System.out.println(On2("pwwkew"));
        // lengthOfLongestSubstring("pwwkew");
        // lengthOfLongestSubstring("");
        // lengthOfLongestSubstring("qwer");
        // lengthOfLongestSubstring("aa");
        
    }

    public static boolean areDistinct (String input, int i, int j) {
        boolean[] visited = new boolean[256]; // Note : Default values in visited are false 
        for (int k = i; k <= j; k++) { // Check from that input index to the j'th index value (inclusive)
            if (visited[input.charAt(k)] == true) 
                return false;
            visited[input.charAt(k)] = true;
        }
        return true;

    }
    public static int On3(String input) {
        int length = input.length();
        int result = 0; 
        if (length == 0 || length == 1) return length; //Handle the edge case
        for (int i = 0; i < length; i++) { 
            for (int j = i; j < length; j++) { //Start from the i'th index onwards only
                if (areDistinct(input, i, j)) {
                    result = Math.max(result, j - i + 1); //See what is greater, the current result or the new distinct one
                }
            }
        }
        return result; 
    }

    public static int On2(String input) {
        int length = input.length();
        int result = 0; 
        if (length == 0 || length == 1) return length; //Handle the edge case
        for (int i = 0; i < length; i++) { 
            boolean[] visited = new boolean[256]; // Note : Default values in visited are false 
            for (int j = i; j < length; j++) { //Start from the i'th index onwards only
                if (visited[input.charAt(j)] == true) 
                    break;
                else {
                    result = Math.max(result, j - i + 1); //See what is greater, the current result or the new distinct one
                    visited[input.charAt(j)] = true;
                }
            }
            visited[input.charAt(i)] = false; // Remove the first character of previous window 
        }
        return result; 
    }

    public static int On(String input) {
        final int NO_OF_CHARS = 256;
        int length = input.length();
        int result = 0; 
        if (length == 0 || length == 1) return length; //Handle the edge case
        int[] lastIndex = new int[NO_OF_CHARS]; // Note : Default values in visited are false 
        Arrays.fill(lastIndex, -1);
        int i = 0; // Initialize start of current window 
        for (int j = 0; j < length; j++) { // Start from the i'th index onwards only - This is the end of current window
            i = Math.max(i, lastIndex[input.charAt(j)] + 1); // Find the last index of str[j] Update i (starting index of current window) as maximum of current value of i and last index plus 1
            result = Math.max(result, j - i + 1); //See what is greater, the current result or the new distinct one  
            lastIndex[input.charAt(j)] = j;
        }
        return result; 
    }
}
