package Chapter16_Moderate;

import java.util.HashMap;

public class Q2_WordFrequencies {
    public static void main(String[] args) {

    }

    public static HashMap<String, Integer> setUpDictionary(String[] book) {
        HashMap<String, Integer> table = new HashMap<>();
        for (String word : book) {
            word = word.toLowerCase();
            if (word.trim() != "") {
                if (table.containsKey(word)) {
                    table.put(word, 0);
                }
                table.put(word, table.get(word) + 1);
            }
        }
        return table;
    }

    public static int getWordFrequency(String word, HashMap<String, Integer> table) {
        if (word == null || table == null) {
            return -1;
        }
        word = word.toLowerCase();
        if (table.containsKey(word)) {
            return table.get(word);
        }
        return 0;
    }
}
