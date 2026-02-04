package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordComparator {

    private List<Integer> getPerfectMatchedIndex(String inputWord, String todayWord) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputWord.length(); i++) {
            if (inputWord.charAt(i) == todayWord.charAt(i)) {
                list.add(i);
            }
        }

        return list;
    }

    private List<Integer> getPartialMatchedIndex(String inputWord, String todayWord) {

        Map<Character, Integer> todayWordMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (char c : todayWord.toCharArray()) {
            todayWordMap.put(c, todayWordMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> perfectMatchedIndexes = getPerfectMatchedIndex(inputWord, todayWord);

        for (int i = 0; i < inputWord.length(); i++) {
            if (perfectMatchedIndexes.contains(i)) continue;

            if (todayWordMap.containsKey(inputWord.charAt(i))) {
                list.add(i);
                todayWordMap.put(inputWord.charAt(i), todayWordMap.get(inputWord.charAt(i)) - 1);

                clearMap(todayWordMap, inputWord.charAt(i));
            }
        }

        return list;
    }

    public WordResult compare(String input, String answer) {
        List<Integer> partial = getPartialMatchedIndex(input, answer);
        List<Integer> perfect = getPerfectMatchedIndex(input, answer);
        return new WordResult(answer.length(), partial, perfect);
    }

    private void clearMap(Map<Character, Integer> todayWordMap, char key) {
        if (todayWordMap.get(key) == 0) {
            todayWordMap.remove(key);
        }
    }
}
