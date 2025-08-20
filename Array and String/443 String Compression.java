class Solution {
    public int compress(char[] chars) {
        int sCount = 0; 
        int amount = 1;
        char c = chars[0];
        if(chars.length == 1){
            return 1;
        }
        for (int i = 1; i < chars.length; i++){
            if(chars[i] == c){
                amount++;
            }else{
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
                c = chars[i]; 
                amount = 1;
            }if (i == chars.length-1 && chars[i] == c){
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
                
                c = chars[i]; 
                amount = 1;
            }
        }
        return sCount; 
    }
}