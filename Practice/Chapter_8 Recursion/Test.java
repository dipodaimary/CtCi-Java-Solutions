package Recursion;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            set.add(i + 1);
        }
        ArrayList<ArrayList<Integer>> allSubsets = getSubset(set);
        for (int i = 0; i < allSubsets.size(); i++) {
            System.out.println(allSubsets.get(i).toString());
        }
    }

    public static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    public static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << set.size();//calculate 2^n
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> subset = convertIntToSet(i, set);
            allSubsets.add(subset);
        }
        return allSubsets;
    }
}
