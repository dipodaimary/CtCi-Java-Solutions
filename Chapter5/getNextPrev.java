package Chapter5;

public class getNextPrev {
    public static void main(String[] args) {
        System.out.println(getNext(7));
        System.out.println(getPrev(7));
    }

    public static int getNext(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;
        int p = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        if (c0 + c1 == 31 && c0 + c1 == 0) {
            return -1;
        }
        p = c0 + c1;
        num |= (1 << p);
        num &= ~((1 << p) - 1);
        num |= (1 << (c1 - 1)) - 1;
        return num;
    }

    public static int getPrev(int num) {
        int temp = num;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        if (temp == 0) {
            return -1;
        }
        while ((temp & 1) == 0 && temp != 0) {
            c0++;
            temp >>= 1;
        }
        int p = c0 + c1;
        num &= ((~0) << (p + 1));
        int mask = (1 << (c1 + 1)) - 1;
        num |= mask << (c0 - 1);
        return num;
    }
}
