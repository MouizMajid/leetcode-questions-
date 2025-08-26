class Solution {
    public boolean isSubsequence(String s, String t) {
        // Edge case: An empty string is a subsequence of any string
        if(s.equals("")){
            return true;
        }
        // convert strings to arrays
        char[] sub = s.toCharArray();
        char[] arr = t.toCharArray();
        // initialize a pointer for the subsequence array
        int sCount = 0; 

        // iterate through the main array
        for(int i = 0; i < arr.length; i++){
            // increment the subsequence pointer if we find a matching character
            if(sub[sCount] == arr[i]){
                sCount++;
            }
            // if we've matched all characters in the subsequence, return true
            if(sCount == sub.length){
                return true;
            }
        }
        // if we finish iterating through the main array without reaching the end, return false
        return false;
    }
}