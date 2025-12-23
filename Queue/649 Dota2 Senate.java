import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> R = new ArrayDeque<>();
        Deque<Integer> D = new ArrayDeque<>();
        
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R'){
                R.add(i);
            }else{
                D.add(i);
            }
        }

        while(R.size() > 0 && D.size() > 0){
            if(R.getFirst() < D.getFirst()){
                D.removeFirst();
                int temp = R.removeFirst(); 
                R.add(temp+senate.length()); 
            }else{
                R.removeFirst();
                int temp = D.removeFirst(); 
                D.add(temp+senate.length()); 
            }
        }
        return R.size() == 0 ? "Dire" : "Radiant"; 
    }
}


/*
    This question was stupid 


    9/10 difficulty 
    took 40 minutes 



*/