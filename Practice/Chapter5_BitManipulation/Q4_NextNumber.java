package BitManipulation;

public class Q4_NextNumber {
    public static void main(String[] args) {
        System.out.println(getNext(13948));
        System.out.println(getPrevious(13948));
    }

    private static int getNext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }
        while (((c & 1) == 1)) {
            c1++;
            c >>= 1;
        }
        //Error if n=11..1100..00
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        int p = c0 + c1;
        n |= (1 << p);//Flip pth bit
        n &= ~((1 << p) - 1); // clear bits from 0 through p-1 th bit
        n |= (1 << (c1 - 1)) - 1;
        return n;
    }

    private static int getPrevious(int n) {
        int temp = n;
        int c1 = 0;
        int c0 = 0;
        while (((temp & 1) == 1)) {
            c1++;
            temp >>= 1;
        }
        while (((temp & 1) == 0) && temp != 0) {
            c0++;
            temp >>= 1;
        }
        int p = c0 + c1;
        n &= ((~0) << (p + 1));
        int mask = (1 << (c1 + 1)) - 1;
        n |= mask << (c0 - 1);
        return n;
    }
}
