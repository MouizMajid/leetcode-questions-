import java.util.ArrayDeque;
import java.util.Deque;

class RecentCounter {

    Deque<Integer> a;

    public RecentCounter() {
        a = new ArrayDeque<>(); 
    }   
    
    public int ping(int t) {
        a.addLast(t);

        while(a.getFirst() < (t-3000)){
            a.removeFirst();
        }
 
        return a.size(); 
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

/*
    This was a bit tricky. I got it with the help of Claude LLM.
    
    You need to keep track of the 3000ms most recent pings. 
    So you need to constantly get rid of old ones. 

    Step 1. make constructor with deque
    Step 2. add t to the deque
    Step 3. while the first element is less than t-3000, remove it
    Step 4. return the size of the deque

    I rate this question a 6/10 for difficulty.
    took 30 minutes

    */