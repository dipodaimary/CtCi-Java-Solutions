package SortingAndSearching;

public class SparseSearch {
    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "ac", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "ac"));
    }

    public static int search(String[] strings, String str) {
        if (strings == null || str == null || str.isEmpty()) {
            return -1;
        }
        return search(strings, str, 0, strings.length - 1);
    }

    private static int search(String[] strings, String str, int first, int last) {
        if (last < first) {
            return -1;
        }
        int mid = (first + last) / 2;
        //If mid is empty find the closet non-empty string
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > left) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        //check for string recurse if necessary
        if (str.equals(strings[mid])) {
            return mid;
        } else if (strings[mid].compareTo(str) < 0) {
            //search right
            return search(strings, str, mid + 1, last);
        } else {
            //search left
            return search(strings, str, first, mid - 1);
        }
    }
}
