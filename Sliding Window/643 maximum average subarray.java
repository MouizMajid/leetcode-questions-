class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Edge case
        if (k > nums.length){
            return 0;
        }
        // average of first k elements
        double average = 0; 
        for(int i = 0; i < k; i++){
            average += nums[i];
        }

        // max average
        double max = average;
        // sliding window
        for(int i = k; i < nums.length; i++){
            // add next element and remove first element of previous window
            average += nums[i] - nums[i-k];
            // update max
            if(average > max){
                max = average;
            }
        }
        // return max average
        return max/k;
    }
}

/*
    This question was pretty easy. Heres how to solve it:
    1. First, we calculate the average of the first k elements in the array.
    2. We then initialize a variable max to keep track of the maximum average found so far.
    3. We then use a sliding window approach to iterate through the array, starting from the k-th element.
    4. For each element, we add the current element to the average and subtract the element that is k positions behind it.
    5. We then check if the new average is greater than the max average found so far, and if so, we update max.
    6. Finally, we return the max average divided by k to get the final result

    

 */