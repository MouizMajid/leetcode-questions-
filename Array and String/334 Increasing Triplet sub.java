class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int smallest = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= smallest){
                smallest = nums[i];
            }
            else if (nums[i] <= middle){
                middle = nums[i];
            }
            else { 
                return true;
            }
        }
        return false;
    }
}

/*

Date: 8/19/2025
 * My approach to this question was to iterate through the array and keep track of the smallest
 * and middle values. if i find a number that is larger than the middle value, i return true.
 * 
 * I used two variables, smallest and middle, to keep track of the smallest and middle values.
 * I updated these variables as I iterated through the array.
 * 
 * If I find a number that is larger than the middle value, it means we have found an increasing triplet,
 * so I return true. If we finish iterating through the array without finding such a triplet, I return false.
 * 
 * I rate this question a 9/10 on difficulty. I resorted to reading the solution after trying for a while.
 * 
 * Time taken to complete: 15 minutes
 */