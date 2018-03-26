package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class Q3_FlipBitToWin {
    public static void main(String[] args) {
        ArrayList out = getAlternatingSequenc(8);
        System.out.println(Arrays.toString(out.toArray()));
        System.out.println(findLongestSequence(out));
    }

    public static ArrayList<Integer> getAlternatingSequenc(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();
        int searchingFor = 0;
        int counter = 0;
        for (int i = 0; i < Integer.BYTES * 8; i++) {
            if ((n & 1) != searchingFor) {
                sequences.add(counter);
                //Flip 0 to 1 or 1 to 0
                searchingFor = 1 & n;
                counter = 0;
            }
            counter++;
            n >>>= 1;
        }
        sequences.add(counter);
        return sequences;
    }

    public static int findLongestSequence(ArrayList<Integer> seq) {
        int maxSeq = 1;
        for (int i = 0; i < seq.size(); i += 2) {
            int zeroSeq = seq.get(i);
            int oneSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int oneSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;
            int thisSeq = 0;
            if (zeroSeq == 1) {
                //can merge
                thisSeq = oneSeqLeft + 1 + oneSeqRight;
            } else if (zeroSeq > 1) {
                //just add 1 to either side and take the max
                thisSeq = 1 + Math.max(oneSeqLeft, oneSeqRight);
            } else if (zeroSeq == 0) {
                //No zero but take either side;
                thisSeq = Math.max(oneSeqLeft, oneSeqRight);
            }
            maxSeq = Math.max(maxSeq, thisSeq);
        }
        return maxSeq;
    }
}
