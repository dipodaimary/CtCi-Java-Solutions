package SortingAndSearching.Q4_SortedSearchNoSizeListy;

public class Listy {
    int[] array;

    public Listy(int[] arr) {
        array = arr.clone();
    }

    public int elementAt(int index) {
        if (index >= array.length) {
            return -1;
        } else {
            return array[index];
        }
    }
}
