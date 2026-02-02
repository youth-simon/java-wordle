package view;

import model.WordResult;

import java.util.ArrayList;
import java.util.List;

public class WordDrawer {

    private final List<WordResult> history = new ArrayList<>();

    public void addResult(WordResult result) {
        history.add(result);
    }

    public void showPrompt() {
        StringBuilder sb = new StringBuilder();
        for (WordResult result : history) {
            for (String s : result.getTiles()) {
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
