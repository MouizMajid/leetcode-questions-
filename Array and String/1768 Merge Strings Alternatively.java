class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Step 1: Determine the length of the longer word.
        // This tells us how many iterations we need to make sure we cover both words.
        int length = (word1.length() > word2.length()) ? word1.length() : word2.length();

        // Step 2: Use a StringBuilder to efficiently build the merged string.
        StringBuilder s = new StringBuilder();

        // Step 3: Loop through all indices up to the longer length.
        for (int i = 0; i < length; i++) {
            // Append a character from word1 if it exists at this index
            if (i < word1.length()) {
                s.append(word1.charAt(i));
            }

            // Append a character from word2 if it exists at this index
            if (i < word2.length()) {
                s.append(word2.charAt(i));
            }
        }

        // Step 4: Convert the StringBuilder back to a string and return it.
        return s.toString();
    }
}


/*
Rubber Duck Walkthrough (Explaining the Thought Process):

- Problem: Merge two strings alternately. If one string is longer,
  append the remaining characters at the end.

- Step 1: Determine which string is longer to know how many iterations we need.
- Step 2: Use StringBuilder to efficiently build the result string.
- Step 3: Loop through each index up to the max length:
    • If the current index exists in word1, append its character.
    • If the current index exists in word2, append its character.
  This ensures we don’t go out of bounds for the shorter string.
- Step 4: Return the merged string.

- Example:
    word1 = "abc", word2 = "pqrs"
    Step 1: length = 4
    Step 3: i=0 → "ap", i=1 → "apbq", i=2 → "apbqcr", i=3 → "apbqcrs"
    Result = "apbqcrs"

Difficulty rating: 2/10  
Time taken: ~20 minutes
*/
