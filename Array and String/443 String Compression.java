class Solution {
    public int compress(char[] chars) {
        //sCount is for 
        int sCount = 0; 
        // amount is for counting the number of times a character appears consecutively
        int amount = 1;
        // c is for keeping track of the current character we are counting
        char c = chars[0];
        // base case for when the array has only one character
        if(chars.length == 1){
            return 1;
        }
        for (int i = 1; i < chars.length; i++){
            // if the current character is the same as the last one we saw, increment amount
            if(chars[i] == c){
                amount++;
            }else{
                // if we see a different character, we need to write this character to the array
                //chars[sCount++] = c;
                sCount++;
                // the code below handles converting the amount to characters and writing them to the array
                if(amount > 1 && amount <= 9){
                    chars[sCount++] = (char) (amount + '0');
                }else if (amount > 9){
                    String sAmount = Integer.toString(amount);
                    char[] cAmount = sAmount.toCharArray();
                    for(int j = 0; j<cAmount.length; j++){
                        chars[sCount++] = cAmount[j];
                    }
                }
                // update c
                c = chars[i]; 
                // reset amount
                amount = 1;
            }
            // edge case for the last character in the array
            if (i == chars.length-1 && chars[i] == c){
                chars[sCount++] = c;
                if(amount > 1 && amount <= 9){
                    chars[sCount++] = (char) (amount + '0');
                }else if (amount > 9){
                    String sAmount = Integer.toString(amount);
                    char[] cAmount = sAmount.toCharArray();
                    for(int j = 0; j<cAmount.length; j++){
                        chars[sCount++] = cAmount[j];
                    }
                }
                // c = chars[i]; 
                // amount = 1;
            }
        }
        return sCount; 
    }
}