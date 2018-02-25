package Chapter8;

import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        //ArrayList<ArrayList<Integer>> power = getSubsets(arr, 0);
        ArrayList<ArrayList<Integer>> power = getSubsets2(arr);
        for (int i = 0; i < power.size(); i++) {
            for (int j = 0; j < power.get(i).size(); j++) {
                System.out.print(power.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (index == set.size()) {//base case empty set
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubet = new ArrayList<>();
                newSubet.addAll(subset);
                newSubet.add(item);
                moresubsets.add(newSubet);
            }
            allSubsets.addAll(moresubsets);
        }
        return allSubsets;
    }

    public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> arr) {

        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << arr.size();
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, arr);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    private static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> arr) {
        int index = 0;
        ArrayList<Integer> subset = new ArrayList<>();
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(arr.get(index));
            }
            index++;
        }
        return subset;
    }
}
