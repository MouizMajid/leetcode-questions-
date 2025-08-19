import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>();

        // Step 1: First, I need to figure out which kid currently has the MOST candies.
        // Why? Because that number is the "target" each kid has to reach (or beat) 
        // after we give them the extra candies.
        int largest = candies[0];
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > largest) {
                largest = candies[i]; // keep updating whenever I find a bigger number
            }
        }

        // Step 2: Now I loop through each kid again.
        // For each kid, I imagine giving them all the extraCandies.
        // Then I check: does this new total make them *at least equal* to the largest?
        int withExtra; 
        for (int i = 0; i < candies.length; i++) {
            withExtra = candies[i] + extraCandies;
            if (withExtra >= largest) {
                // If yes → this kid can have the greatest number of candies → mark as true
                result.add(true);
            } else {
                // If no → even with the extra, they don’t reach the top → mark as false
                result.add(false);
            }
        }

        // Step 3: Return the list of true/false values for each kid
        return result;
    }   
}

/* 
Rubber Duck Walkthrough:

- The problem asks: after giving each kid extraCandies, can they become 
  the kid with the greatest number of candies? 
- To answer this, I first find the maximum number of candies that any kid has right now. 
  This acts like a "threshold" to beat. 
- Then, for each kid, I add the extraCandies to their total and check if they reach 
  or surpass that threshold. If they do, I mark them as true; if not, false. 
- In the end, I have a list where each index tells me if that kid could become the top.

Difficulty: 2/10  
Time taken: ~20 minutes
*/
