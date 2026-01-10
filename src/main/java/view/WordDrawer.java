package view;

import model.TrialCounter;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class WordDrawer {

    static List<char[]> list = new ArrayList<>();


    public static void draw(List<Integer> partialMatchedIndexes, List<Integer> perfectlyMatchedIndexes) {

        char[] result = new char[5];
        Arrays.fill(result, 'B');

        for (int partialMatchedIndex : partialMatchedIndexes) {
            result[partialMatchedIndex] = 'Y';
        }

        for (int perfectlyMatchedIndex : perfectlyMatchedIndexes) {
            result[perfectlyMatchedIndex] = 'G';
        }

        list.add(result);
    }

    public static void showPrompt(int trials) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trials; i++) {
            for (char c : list.get(i)) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
