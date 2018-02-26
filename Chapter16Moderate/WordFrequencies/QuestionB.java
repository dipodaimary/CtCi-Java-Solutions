package Chapter16Moderate.WordFrequencies;

import java.util.HashMap;

public class QuestionB {
    public static HashMap<String, Integer> setUpDictionary(String[] book) {
        HashMap<String, Integer> table = new HashMap<>();
        for (String word : book) {
            word = word.toLowerCase();
            if (word.trim() != "") {
                if (!table.containsKey(word)) {
                    table.put(word, 0);
                } else {
                    table.put(word, table.get(word) + 1);
                }
            }
        }
        return table;
    }

    public static int getFrequency(HashMap<String, Integer> table, String word) {
        if (table == null || word == null) {
            return -1;
        }
        word = word.toLowerCase();
        if (table.containsKey(word)) {
            return table.get(word);
        }
        return 0;
    }
}
