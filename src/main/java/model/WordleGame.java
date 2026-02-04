package model;

import controller.WordInputHandler;
import view.FileReader;
import view.WordDrawer;

import java.io.IOException;

public class WordleGame {

    private final WordInputHandler inputHandler;
    private final TrialCounter trialCounter;
    private final WordComparator comparator;
    private final WordDrawer drawer;
    private final String todayWord;

    public WordleGame() throws IOException {
        FileReader fileReader = new FileReader();
        this.todayWord = fileReader.read("./words.txt");

        inputHandler = new WordInputHandler();
        trialCounter = new TrialCounter();
        comparator = new WordComparator();
        drawer = new WordDrawer();
    }

    public void start() {
        while (trialCounter.keepTrying()) {
            playTurn();
        }
        WordDrawer.showTheEnd(trialCounter.isGameOver());
    }

    private void playTurn() {
        System.out.println("정답을 입력해 주세요.");
        String input = inputHandler.inputWord();
        trialCounter.increment();

        WordResult result = comparator.compare(input, todayWord);

        if (result.isPerfect()) {
            trialCounter.gameOver();
        }

        drawer.addResult(result);
        drawer.showPrompt();
    }
}
