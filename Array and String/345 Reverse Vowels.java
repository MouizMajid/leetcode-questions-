import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String reverseVowels(String s) {
        // Step 1: Convert the string into a character array
        // (so we can directly modify characters).
        char[] arr = s.toCharArray();

        // Step 2: Keep a list of the vowels we encounter (in the order they appear).
        ArrayList<Character> vowelsInWord = new ArrayList<>(); 

        // Step 3: Define a set of vowels (lowercase only, but we'll convert chars before checking).
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Step 4: First pass — collect all vowels from the string.
        // Example: "hello" → vowelsInWord = ['e', 'o']
        for(int i = 0; i < arr.length; i++){
            if(vowels.contains(Character.toLowerCase(arr[i])) ){
                vowelsInWord.add(arr[i]);
            }
        }

        // Step 5: Now we’ll put the vowels back, but in reverse order.
        int index = vowelsInWord.size() - 1; // Start from the last vowel collected.

        for(int i = 0; i < arr.length; i++){
            // If this character is a vowel, replace it with the "last" vowel
            // from our collected list, then move the index backward.
            if(vowels.contains(Character.toLowerCase(arr[i])) ){
                arr[i] = vowelsInWord.get(index);
                index--;
            }
        }

        // Step 6: Return the modified character array as a new string.
        return new String(arr);
    }
}


/*
    Rubber Duck Walkthrough (Explaining the Thought Process):

    - The problem: Reverse only the vowels in the string, while leaving all
      consonants and other characters in their original positions.

    - My approach:
        1. Convert the string into a char array so it's easier to change letters.
        2. Define a set of vowels (a, e, i, o, u). Use Character.toLowerCase()
           so it works for both upper and lowercase inputs.
        3. First pass: loop through the string and collect all vowels into a list.
           Example: "leetcode" → ['e','e','o','e']
        4. Second pass: loop through the string again. Every time I see a vowel,
           replace it with the vowel from the *end* of my list, then move leftward.
           This ensures vowels get placed in reverse order.
        5. Return the new string.

    - Example:
        Input: "hello"
        Step 1 (collect vowels): ['e','o']
        Step 2 (replace in reverse):
            h → h
            e → o
            l → l
            l → l
            o → e
        Result = "holle"

    - Limitations:
        This approach uses extra space (ArrayList + Set).
        A more optimal solution uses two pointers (left and right) to swap vowels
        directly in the char array, which avoids the extra memory usage.

    - Complexity:
        Time: O(n) because we scan the array twice.
        Space: O(n) because we store vowels in a separate list.

    Difficulty rating: 3/10
    Time spent: ~30 minutes
*/
