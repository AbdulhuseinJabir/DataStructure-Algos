import java.util.HashMap;

/*
* This program is to find the first non-repeating character in a string. 
*/


public class String_firstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(On_Array("aaaadbbbccc"));
    }
    
    public static char On_HashMap(String s) { // This is the implementation using a HashMap.
        HashMap<Character, Integer> char_counts = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (char_counts.containsKey(c))
                char_counts.put(c, char_counts.get(c) + 1);
            else
                char_counts.put(c, 1);
        }

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (char_counts.get(c) == 1)
                return c;
        }

        return '_';
    }

    public static char On_Array(String s) {
        int[] alphabets  = new int[26];
        for (char c : s.toCharArray()) {
            alphabets[c - 'a']++;            
        }

        for (char c : s.toCharArray()) {
            if (alphabets[c - 'a'] == 1)
                return c;
        }

        return '_';

    }
}
