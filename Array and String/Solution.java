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
            word.append(" ");
        }
        
    return word.toString();
    }
}