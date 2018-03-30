package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Q4_Power_Set {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> allSubSets = getSubsets(list, 0);
        for (int i = 0; i < allSubSets.size(); i++) {
            System.out.println(allSubSets.get(i).toString());
        }
        System.out.println("****************************************************************");
        allSubSets = getSubsetsCombinatorics(list);
        for (int i = 0; i < allSubSets.size(); i++) {
            System.out.println(allSubSets.get(i).toString());
        }
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) {//Base case -add empty set
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<Integer>());//Empty set
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    public static ArrayList<ArrayList<Integer>> getSubsetsCombinatorics(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size(); /* Compute 2^n */
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allsubsets.add(subset);
        }
        return allsubsets;
    }
}
