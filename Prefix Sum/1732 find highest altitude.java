class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int alt =  gain[0]; 
        max = Math.max(alt, max); 
        for(int i = 1; i < gain.length; i++){
            alt = gain[i] + gain[i-1]; 
            gain[i] +=  gain[i-1]; 
            max = Math.max(alt, max); 


        }
        return max; 
    }
}


/*

    This question was really easy. I rate this question 2/10 for difficulty.
    Heres how to solve it: 
    1. We start at an altitude of 0.
    2. We then iterate through the gain array, adding each element to the current altitude
    3. We keep track of the maximum altitude reached during the iteration.
    4. Finally, we return the maximum altitude reached.
    5. Note that we also consider the starting altitude of 0 as a potential maximum altitude.


 */