class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        // This array will hold our final answer.
        int[] answer = new int[len];
        
        // Step 1: Initialize all positions to 1.
        // We need this because we’ll be multiplying values into it.
        for (int i = 0; i < len; i++){
            answer[i] = 1;
        }

        // Step 2: Build prefix products (products of everything to the LEFT of i).
        // Example: nums = [1,2,3,4]
        // Prefix products would be: [1, 1, 2, 6]
        for (int i = 1; i < len; i++){
            answer[i] = nums[i-1] * answer[i-1];
        }

        // Step 3: Traverse from the RIGHT and multiply suffix products.
        // We'll keep track of the "running product" of all numbers to the right.
        int right = nums[len -1];  // Start with the very last element.

        for (int i = len - 2; i >= 0; i--){
            // Multiply the current answer (which already has the prefix product)
            // by the suffix product (everything to the right).
            answer[i] = right * answer[i];

            // Update "right" so that it includes this element as well.
            // On the next iteration, "right" will represent
            // the product of everything to the right of the next index.
            right *= nums[i];

            // Example walkthrough with nums = [1,2,3,4,5]:
            // Prefix step produced: [1,1,2,6,24]
            // Right-to-left updates: [120,60,40,30,24]
        }

        // Step 4: Return the completed array.
        return answer;
    }
}

/*
    Rubber Duck Walkthrough (Explaining the Thought Process):

    - Problem: For each index, calculate the product of ALL numbers in the array
      except the one at that index. Division is not allowed.

    - Key insight:
        Instead of directly excluding each element, we can precompute:
        1. The product of everything to the LEFT of that index.
        2. The product of everything to the RIGHT of that index.
        Multiply them together → that’s the answer for that index.

    - Implementation details:
        • First loop: Build prefix products in "answer".
            At index i, answer[i] = product of all nums before i.
        • Second loop: Traverse backwards with a running "right" product.
            Multiply answer[i] by the running suffix product,
            then update suffix for the next iteration.

    - Why it works:
        Every element at index i gets multiplied by:
            (all elements before it) * (all elements after it)
        without ever directly including nums[i].

    - Complexity:
        Time: O(n) because we only loop twice through the array.
        Space: O(1) extra (ignoring output array).

    Difficulty rating: 9/10
    Time spent: ~45 minutes (needed to read solution)
*/
