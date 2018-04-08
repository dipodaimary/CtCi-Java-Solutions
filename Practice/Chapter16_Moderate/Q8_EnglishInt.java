package Chapter16_Moderate;

import java.util.LinkedList;

public class Q8_EnglishInt {
    static String[] smalls = {"Zero", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ",
            "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Fourteen ",
            "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    static String[] tens = {"", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] bigs = {"", "Thousand", "Million", "Billion"};
    static String hundred = "Hundred";
    static String negative = "Negative";

    public static void main(String[] args) {
        System.out.println(convert(1091034849));
    }

    public static String convert(int num) {
        if (num == 0) {
            return smalls[num];
        } else if (num < 0) {
            return negative + " " + convert(-1 * num);
        }
        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                String chunk = convertChunk(num % 1000) + " " + bigs[chunkCount];
                parts.addFirst(chunk);
            }
            num = num / 1000;
            chunkCount++;
        }
        return listToString(parts);
    }

    public static String convertChunk(int num) {
        LinkedList<String> parts = new LinkedList<>();
        if (num >= 100) {
            parts.addLast(smalls[num / 100]);
            parts.addLast(hundred);
            num %= 100;
        }
        /*
        Convert Ten's place
         */
        if (num >= 10 && num <= 19) {
            parts.addLast(smalls[num]);
        } else if (num >= 20) {
            parts.addLast(tens[num / 10]);
            num %= 10;
        }
        if (num >= 1 && num <= 9) {
            parts.addLast(smalls[num]);
        }
        return listToString(parts);
    }

    private static String listToString(LinkedList<String> parts) {
        StringBuilder sb = new StringBuilder();
        while (parts.size() > 1) {
            sb.append(parts.poll());
            sb.append(" ");
        }
        sb.append(parts.pop());
        return sb.toString();
    }
}
