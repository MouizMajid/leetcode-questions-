import java.util.HashSet; // Import the HashSet class
import java.util.List; // Import the HashSet class
import java.util.ArrayList; // Import the HashSet class

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> l1 = new HashSet<>();
        HashSet<Integer> l2 = new HashSet<>();

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int x : nums1) {
            l1.add(x);
        }
        for (int x : nums2) {
            l2.add(x);
        }

        for (int i : l2) {
            if (!l1.contains(i)) {
                second.add(i);
            }
        }

        for (int i : l1) {
            if (!l2.contains(i)){
                first.add(i);
            }
        }

        List<List<Integer>> nestedList = new ArrayList<>();
        nestedList.add(first);
        nestedList.add(second);
        return nestedList; 

    }
}