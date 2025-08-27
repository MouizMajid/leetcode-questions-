class Solution {
    public int maxArea(int[] height) {
        // amount is the max volume of water we can contain
        int amount = 0;
        // i is the left pointer
        int i = 0;
        // j is the right pointer
        int j = height.length - 1;
        // max is the smaller of the two heights at the pointers
        int max = 0;
        while (i < height.length && j > 0 && j != i) {
            // set max to the smaller of the two heights
            max = (height[i] <= height[j]) ? height[i] : height[j];
            // calculate the volume of water that can be contained
            int volume = ((j - i) * max);
            // update amount if the current volume is greater
            if (amount < volume) {
                amount = volume;
            }
            // move the pointer at the shorter height inward
            int x = (height[i] <= height[j]) ? i++ : j--;
        }
        return amount;
    }
}

/*
    Rubber Duck Walkthrough (Explaining the Thought Process):

    this question was a bit tricky for me to understand at first.
    the problem wants us to find the maximum area of water that can be contained
    between two lines represented by the heights in the array.

    to do this, we can use a two-pointer approach:
    1. initialize two pointers, one at the start (left) and one at the end (right) of the array.
    2. calculate the area formed between the two lines at these pointers. 
    3. move the pointer at the shorter line inward, because moving the taller line won't help increase the area.
    4. repeat this process until the two pointers meet.    
    5. keep track of the maximum area found during this process.
    6. return the maximum area.
    
    i rate this problem a 6/10 in difficulty.
    time taken: ~35 minutes
 */