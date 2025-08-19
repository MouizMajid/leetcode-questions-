class Solution {
    public boolean increasingTriplet(int[] nums) {
        // If the array has less than 3 numbers, it's impossible to have a triplet.
        if (nums == null || nums.length < 3) {
            return false;
        }

        // We'll keep track of the smallest number we've seen so far,
        // and the second smallest number (the "middle" of the triplet).
        int smallest = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        // Now we scan through the array one number at a time.
        for (int i = 0; i < nums.length; i++) {
            
            // Case 1: If the current number is smaller than or equal to our "smallest",
            // then update "smallest". This means we've found a new starting point.
            if (nums[i] <= smallest) {
                smallest = nums[i];
            }

            // Case 2: Otherwise, if the current number is bigger than "smallest"
            // but still smaller than or equal to "middle", then this number
            // is a good candidate for the "middle" of the triplet.
            else if (nums[i] <= middle) {
                middle = nums[i];
            }

            // Case 3: If the current number is bigger than both "smallest" and "middle",
            // that means we found a third number that comes after them
            // and forms an increasing triplet. So we can return true immediately.
            else { 
                return true;
            }
        }

        // If we finished looping without finding a valid third number,
        // then no increasing triplet exists in this array.
        return false;
    }
}

/*
    Rubber Duck Walkthrough (Explaining the Thought Process):

    - The problem asks if there exists 3 numbers in increasing order somewhere in the array.
    - Instead of trying every possible triplet (which would be too slow),
      I only need to track the "shape" of a triplet:
        1. the smallest number
        2. the middle number (which is bigger than the smallest)
        3. the third number (which is bigger than the middle)
    
    - So I keep two variables:
        smallest → the best "first number" candidate I've seen so far
        middle   → the best "second number" candidate I've seen so far

    - As I scan:
        • If I find a smaller "smallest", I reset my starting point.
        • If I find a number bigger than smallest but smaller than middle,
          I update middle (new candidate for the second number).
        • If I find a number bigger than both smallest and middle,
          I’ve successfully found the 3rd number → return true immediately.

    - If I finish looping without hitting case 3, then no triplet exists → return false.

    Date: 8/19/2025
    Difficulty rating: 9/10
    Time spent: ~60 minutes (needed to look at solution eventually)
*/