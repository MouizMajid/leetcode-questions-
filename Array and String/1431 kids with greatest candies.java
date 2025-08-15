import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>();

        int largest = candies[0];
        for (int i = 0; i < candies.length; i++){
            if (candies[i] > largest){
                largest = candies[i];
            }
        }
        int withExtra; 
        for (int i = 0; i < candies.length; i++){
            withExtra = candies[i] + extraCandies ;
            if (withExtra >= largest){
                result.add(true);
            }else{
                result.add(false);
            }
        }

        return result;
    }   
}

/* 
heres my approach. 
so first i need to find the index of the largest number 
in the candies array. we can do this with a for loop. 

with that and in another for loop, ill compare candy number at index i plus 
extraCandies everytime to the largest and if its bigger than the largest,
 that makes it bigger than the rest of the indexes. we can then 
 automatically give that index a true.

    i rate this question a 2/10 on difficulty. 
    time took to complete: 20 minutes

 */