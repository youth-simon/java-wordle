import controller.WordInputHandler;
import model.TrialCounter;
import model.WordComparator;
import view.WordDrawer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        // 1) FileReader 오늘의 단어 뽑기
        String todayWord = null;
        try (InputStream is = Application.class
                .getClassLoader()
                .getResourceAsStream("words.txt")) {
            if (is == null) {
                throw new IllegalStateException("words.txt file not found");
            }
            todayWord = new String(is.readAllBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // 2) WordInputHandler - prompt + 단어 받기
        TrialCounter trialCounter = new TrialCounter();
        WordInputHandler inputHandler = new WordInputHandler();
        WordComparator wordComparator = new WordComparator();

        while (trialCounter.failCheck()){
            String input = inputHandler.inputWord();
            trialCounter.increment();

            List<Integer> partialMatchedIndexes = wordComparator.getPartialMatchedIndex(input, todayWord);
            List<Integer> perfectlyMatchedIndexes = wordComparator.getPerfectMathcedIndex(input, todayWord);

            WordDrawer.draw(partialMatchedIndexes, perfectlyMatchedIndexes);
            WordDrawer.showPrompt(trialCounter.getTrials());
        }

    }
}
