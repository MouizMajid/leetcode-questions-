import java.util.ArrayList;

class Solution{
    
    public static String reverseWords(String s) {
        // Step 1: Convert the string into a character array
        // This makes it easier to look at each character one by one.
        char[] arr = s.toCharArray();

        // We'll store each completed word in this list.
        ArrayList<String> words = new ArrayList<>();

        // We'll build words character by character before adding them to the list.
        StringBuilder word = new StringBuilder();

        // Step 2: Loop through every character in the string
        for (int i = 0; i < arr.length; i++){

            // Case 1: If the current character is NOT a space,
            // keep building the current word.
            if(arr[i] != ' '){
                word.append(arr[i]);
            }

            // Case 2: If the current character IS a space, but we already
            // have characters in "word", then we've reached the end of a word.
            // → Add it to the words list, then reset the word builder.
            else if (arr[i] == ' ' && word.length() != 0 ){
                words.add(word.toString());
                word.setLength(0);
            }

            // Case 3 (Edge case): If we're at the very last character of the string
            // and it’s not a space, we wouldn’t hit the "space condition" above.
            // → So we manually add the last word to the list here.
            if (arr[i] != ' ' && i == arr.length - 1){
                words.add(word.toString());
                word.setLength(0);
            }
        }

        // Step 3: Now we have all the words in the order they appeared.
        // We need to build the reversed sentence by going backwards.
        for (int i = words.size() -1; i >= 0; i--){
            word.append(words.get(i));
            // Add a space between words, but not after the very last one.
            if(i != 0){
                word.append(" ");
            }
        }
        
        // Step 4: Return the final reversed sentence.
        return word.toString();
    }
}

/*
    Rubber Duck Walkthrough (Explaining the Thought Process):

    - The task is to reverse the order of words in the string,
      but not reverse the characters inside each word.

    - I break it into two parts:
        1. Extract all the words from the string.
        2. Rebuild the sentence by adding those words in reverse order.

    - Extracting words:
        • Loop through each character.
        • Build a word with StringBuilder when characters are not spaces.
        • When a space is found, push the completed word into an ArrayList
          and reset the builder.
        • Special case: if the string ends without a space, add the last word manually.

    - Rebuilding:
        • Loop backwards through the ArrayList of words.
        • Append each word into a new StringBuilder, adding spaces between them.
        • Convert the builder to a final string.

    - Why this works:
        The ArrayList preserves the original order,
        and by looping backwards we naturally reverse the word order.

    Difficulty rating: 5/10
    Time spent: ~60 minutes
*/
