class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1){
            if(flowerbed[0] == 0 || n ==0){
                return true;
            }
        }
        else{
            for (int i = 0; i < flowerbed.length; i++){
                if(i == 0){
                    if(flowerbed[i] == 0 && flowerbed[i+1] ==0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
                else if (i == flowerbed.length-1){
                    if(flowerbed[i] == 0 && flowerbed[i-1] ==0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }else{
                    if(flowerbed[i] == 0 && flowerbed[i+1] ==0  && flowerbed[i-1] ==0){
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
        }  
        if (n<=0){
            return true; 
        }else{
            return false;
        }
    }
}

/*
 heres my approach. so first i need to check if the length of the flowerbed is 1.
 if it is, i need to check if the flowerbed is 0 or if the number of flowers to 
 place is 0. if either of those are true, i return true.

if it isnt 1, i need to iterate through the entire flowerbed and check it.
first i checked the edge cases, if i could place flowers there. i  subtracted
n by 1 everytime i could place a flower and also placed the flower by editing the 
array at the index, tihis is so i can truely make sure that the flowers can fit. 

next i checked the middle cases, if i could place flowers there. i checked both
sides of a valid index and if both sides are 0, i placed the flower and subtracted 1
from n. 

after i iterated through the entire flowerbed, i checked if n was 0 or less. if it was 
negative that just means we can place even more flowers than we need to.
if it was, i returned true. if it wasnt, i returned false.

    i rate this question a 4/10 on difficulty. it woud need some deeper logical
    thinking if i wanted to solve it in a lower memory usage. 

    time took to complete: 20 minutes

 */