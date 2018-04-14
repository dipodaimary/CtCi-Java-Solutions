package Preparation.BankBazaar;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 2, 2, 2, 2, 2, 2};

        System.out.println(search(a, 2));
        System.out.println(search(a, 3));
        System.out.println(search(a, 4));
        System.out.println(search(a, 1));
        System.out.println(search(a, 8));
    }

    public static int search(int[] a, int x) {
        return search(a, 0, a.length - 1, x);
    }

    public static int search(int[] a, int left, int right, int x) {
        int mid = (left + right) / 2;
        if (a[mid] == x) {//found element
            return mid;
        }
        if (right < left) {
            return -1;
        }
        /*
        While there may be an inflection point due to rotation, either the left or right half may be
        normally ordered. We can look at the normally ordered half to take a determination as to which
        half we should search
         */
        if (a[left] < a[mid]) {//Left is normally ordered
            if (x >= a[left] && x <= a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[left] > a[mid]) {//Right is normally ordered
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) {
            /*
            Left is either all repeats or loops aroud with the right half being all duplicates
             */
            if (a[mid] != a[right]) {//If right half is different, search there
                int result = search(a, mid + 1, right, x);
            } else {//We have to search both the halves
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
