class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Special case: if the flowerbed has only 1 spot
        if(flowerbed.length == 1){
            // If the spot is empty (0), or if we don’t need to place any flowers,
            // then it's possible.
            if(flowerbed[0] == 0 || n == 0){
                return true;
            }
        }
        else{
            // General case: loop through the entire flowerbed
            for (int i = 0; i < flowerbed.length; i++){
                
                // Case 1: First slot (left edge).
                // Can place a flower only if it’s empty AND the next slot is empty.
                if(i == 0){
                    if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                        flowerbed[i] = 1; // Place flower
                        n--;              // Decrement flowers left to place
                    }
                }

                // Case 2: Last slot (right edge).
                // Can place a flower only if it’s empty AND the previous slot is empty.
                else if (i == flowerbed.length-1){
                    if(flowerbed[i] == 0 && flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }

                // Case 3: Middle slots.
                // Can place a flower if this slot is empty AND both neighbors are empty.
                else{
                    if(flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }  

        // After placing as many flowers as possible,
        // check if we have placed enough.
        if (n <= 0){
            return true; 
        }else{
            return false;
        }
    }
}


/*
    Rubber Duck Walkthrough (Explaining the Thought Process):

    - Problem: We need to decide if we can place "n" flowers into the flowerbed,
      with the rule that no two flowers can be adjacent.

    - Step 1: Special case check.
        If the flowerbed has only 1 slot:
            • If that slot is empty, OR we don’t need to place any flowers,
              the answer is true.

    - Step 2: Iterate through the flowerbed.
        At each index, we need to decide if a flower can be placed:
        
        • Edge cases:
            - First slot: check only itself and the next slot.
            - Last slot: check only itself and the previous slot.
        
        • Middle slots:
            - Slot must be empty, and both neighbors must also be empty.
        
        If a flower can be placed:
            - Place it (set flowerbed[i] = 1).
            - Decrement n (one fewer flower left to place).

    - Step 3: After looping:
        If n <= 0, it means we’ve placed all required flowers (or even more).
        Otherwise, return false.

    - Why this works:
        By actually "placing" flowers in the array as we go,
        we prevent overlapping placements and ensure spacing rules are followed.

    - Complexity:
        Time: O(n), since we scan the array once.
        Space: O(1), since we modify the array directly.

    Difficulty rating: 4/10
    Time spent: ~20 minutes
*/
