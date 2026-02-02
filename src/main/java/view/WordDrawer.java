package view;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import model.TileColor;

public class WordDrawer {

    static List<String[]> list = new ArrayList<>();

    public static void draw(List<Integer> partialMatchedIndexes, List<Integer> perfectlyMatchedIndexes) {

        String[] result = new String[5];
        Arrays.fill(result, TileColor.WHITE.getEmoji());

        for (int partialMatchedIndex : partialMatchedIndexes) {
            result[partialMatchedIndex] = TileColor.YELLOW.getEmoji();
        }

        for (int perfectlyMatchedIndex : perfectlyMatchedIndexes) {
            result[perfectlyMatchedIndex] = TileColor.GREEN.getEmoji();
        }

        list.add(result);
    }

    public static void showPrompt(int trials) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trials; i++) {
            for (String s : list.get(i)) {
                sb.append(s);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void showTheEnd(boolean gameOver) {
        if (gameOver) {
            System.out.println("You won: The End");
            return;
        }
        System.out.println("You lost: The End");
    }
}
