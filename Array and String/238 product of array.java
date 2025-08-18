class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++){
            answer[i] = 1;
        }
        for (int i = 1; i < len; i++){
            answer[i] = nums[i-1] * answer[i-1];
        
        }
        int right = nums[len -1];
        for (int i = len - 2; i >= 0; i--){
            answer[i] = right * answer[i];
            right *= nums[i];

            // [1,2,3,4,5]
            // [1,1,2,6,24]
            // [120,60,40,30,24]
        }
        return answer;
    }
}

/*
 * This question was pretty hard without division. i resorted to reading the solution. 
 *      First, i needed to compute the left array. this is the values that are the product
 * of everything left of the index. 
 *      same thing with the right, its the same process
 * just iterating through the array backwards. 
 *      then at the end, i multiply the left array values by a variable called
 * right. this variable is the variable that multiplies the values to the right
 * of the array. 
 * 
 * 
 * 
 * i rate this question a 9/10 on difficulty
 * time took to complete: 45 minutes 
 * 
 */