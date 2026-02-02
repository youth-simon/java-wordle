import controller.WordInputHandler;
import model.TrialCounter;
import model.WordComparator;
import model.WordResult;
import view.FileReader;
import view.WordDrawer;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        // 1) FileReader 오늘의 단어 뽑기
        FileReader fileReader = new FileReader();
        String todayWord = fileReader.read("./words.txt");

        // 2) WordInputHandler - prompt + 단어 받기
        TrialCounter trialCounter = new TrialCounter();
        WordInputHandler inputHandler = new WordInputHandler();
        WordComparator wordComparator = new WordComparator();

        WordDrawer drawer = new WordDrawer();

        while (trialCounter.keepTrying()) {
            System.out.println("정답을 입력해 주세요.");
            String input = inputHandler.inputWord();
            trialCounter.increment();

            List<Integer> partialMatchedIndexes = wordComparator.getPartialMatchedIndex(input, todayWord);
            List<Integer> perfectlyMatchedIndexes = wordComparator.getPerfectMatchedIndex(input, todayWord);

            if (perfectlyMatchedIndexes.size() == 5) {
                trialCounter.gameOver();
            }

            WordResult result = new WordResult(5, partialMatchedIndexes, perfectlyMatchedIndexes);
            drawer.addResult(result);
            drawer.showPrompt();
        }

        WordDrawer.showTheEnd(trialCounter.isGameOver());
    }
}
