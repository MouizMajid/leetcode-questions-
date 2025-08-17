import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        ArrayList<Character> vowelsInWord = new ArrayList<>(); 
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(int i = 0; i < arr.length; i++){
            if(vowels.contains (Character.toLowerCase(arr[i])) ){
                vowelsInWord.add(arr[i]);
            }
        }
        int index = vowelsInWord.size() -1;
        for(int i = 0; i < arr.length; i++){
            if(vowels.contains (Character.toLowerCase(arr[i])) ){
                arr[i] = vowelsInWord.get(index);
                index--;
            }
        }
        return new String(arr);
    }
}


/*
  Heres my approach:
   I first convert the string to a character array.
   I then create a set of vowels.
   I then iterate through the character array and add the vowels to an ArrayList.
   I then iterate through the character array and replace the vowels with the vowels
    in the ArrayList in reverse order.
   I then return the new string.
  
  the problem with this approach is that it takes extra time and space. 
  
  
  a better solution is to use two pointers.
  
    i give this question a difficulty of 3/10, it took some thinking but i was able to solve it.
    although, if i wanst allowed to use as much memory as i did, i would find it more difficult.
    time took to solve: 30 minutes
  
  
 */ 