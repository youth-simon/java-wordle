package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class WordComparator {



    public List<Integer> getPerfectMatchedIndex(String inputWord, String todayWord) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < inputWord.length(); i++) {
            if (inputWord.charAt(i) == todayWord.charAt(i)) {
                list.add(i);
            }
        }

        return list;
    }

    public List<Integer> getPartialMatchedIndex(String inputWord, String todayWord) {

        Map<Character, Integer> todayWordMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (char c : todayWord.toCharArray()) {
            todayWordMap.put(c, todayWordMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < inputWord.length(); i++) {
            if (todayWordMap.containsKey(inputWord.charAt(i))) {

                list.add(i);
                todayWordMap.put(inputWord.charAt(i), todayWordMap.get(inputWord.charAt(i)) - 1);

                clearMap(todayWordMap, inputWord.charAt(i));
            }
        }

        return list;
    }

    private void clearMap(Map<Character, Integer> todayWordMap, char key) {
        if (todayWordMap.get(key) == 0) {
            todayWordMap.remove(key);
        }
    }
}
