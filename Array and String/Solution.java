class Solution {

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        compress(chars);
    }
    public static int compress(char[] chars) {
        // int sCount = 0; 
        int amount = 1;
        int arrayLength = 0;
        char c = chars[0];
        for (int i = 1; i < chars.length; i++){
            if(chars[i] == c){
                amount++;
            }else{
                // chars[sCount++] = c;
                // chars[sCount++] = (char) (amount + '0');
                int length = String.valueOf(amount).length();
                arrayLength += (length + 1);
                c = chars[i]; 
                amount = 1;
            }if (i == chars.length-1 && chars[i] == c){
                // chars[sCount++] = c;
                // chars[sCount++] = (char) (amount + '0');
                int length = String.valueOf(amount).length();
                arrayLength += (length + 1);
                c = chars[i]; 
                amount = 1;
            }
        }
        for(char x : chars){
            System.out.print(x + "\n");
        }
        System.out.println(arrayLength);
        return 0; 
    }


}