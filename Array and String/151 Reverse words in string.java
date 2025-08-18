import java.util.ArrayList;

class Solution{
    
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != ' '){
                word.append(arr[i]);
            }else if (arr[i] == ' ' && word.length() != 0 ){
                words.add(word.toString());
                word.setLength(0);
            }
            if (arr[i] != ' ' && i == arr.length - 1){
                words.add(word.toString());
                word.setLength(0);
            }
        }
        for (int i = words.size() -1; i >= 0; i--){
            word.append(words.get(i));
            if(i != 0){
                word.append(" ");
            }
        }
        
    return word.toString();
    }
}

/*
 This was my first medium question ever.
 heres my approach

    first i needed to make the string an array. i would iterate through this
        array and add any non space characters to a stringbuilder object. 
    when i reached a space, i would add the stringbuilder word to the arraylist
        words. then i cleared the stringbuilder
    when i reach the end of the array, if the last element was not a space, my
        code to add the stringbuilder word to the words arraylist would be skipped.
    to avoid this, i had code for the edge case where i reach the end of my array
        and manually added the last word to the words list
    then i iterated through the list backwards and added each word to a 
        stringbuilder

    i rate this question a 5/10 on difficulty 
    time took to complete: 60 minutes
 */
