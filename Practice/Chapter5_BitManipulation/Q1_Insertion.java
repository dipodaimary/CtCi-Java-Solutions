package BitManipulation;

public class Q1_Insertion {
    public static void main(String[] args) {
        int n = 1024;
        int m = 19;
        System.out.println(insertAt(n, m, 2, 6));
        System.out.println(insertAtDipo(n,m,2,6));
    }

    public static int insertAtDipo(int n, int m, int i, int j) {
        int mask = 1;
        mask <<= j;
        mask -= 1;
        mask <<= i;
        mask = (~mask);
        int n_and = n & mask;
        int m2 = m << 2;
        int ans = n_and | m2;
        return ans;
    }

    public static int insertAt(int n, int m, int i, int j) {
        //Create a mask to clear bits i through j in n. Example: i=2, j=4.
        int allOnes = ~0; //will be a sequence of all 1's
        // 1s before position j, then 0s.
        int left = allOnes << (j + 1);
        //1s after position i
        int right = (1 << i) - 1;
        //All ones except for 0s between positions j and i
        int mask = right | left;
        //Clear bits j through i and put m in there
        int n_cleared = n & mask;
        int m_shifted = m << i;
        return n_cleared | m_shifted;
    }
}
