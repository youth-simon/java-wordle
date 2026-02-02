import controller.WordInputHandler;
import model.TrialCounter;
import model.WordComparator;
import view.FileReader;
import view.WordDrawer;

import java.nio.file.Path;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1) FileReader 오늘의 단어 뽑기
        FileReader fileReader = new FileReader();
        String todayWord =  fileReader.read(Path.of("./words.txt"));

        // 2) WordInputHandler - prompt + 단어 받기
        TrialCounter trialCounter = new TrialCounter();
        WordInputHandler inputHandler = new WordInputHandler();
        WordComparator wordComparator = new WordComparator();

        while (trialCounter.keepTrying()){
            String input = inputHandler.inputWord();
            trialCounter.increment();

            List<Integer> partialMatchedIndexes = wordComparator.getPartialMatchedIndex(input, todayWord);
            List<Integer> perfectlyMatchedIndexes = wordComparator.getPerfectMathcedIndex(input, todayWord);

            if (perfectlyMatchedIndexes.size() == 5) {
                trialCounter.gameOver();
            }

            WordDrawer.draw(partialMatchedIndexes, perfectlyMatchedIndexes);
            WordDrawer.showPrompt(trialCounter.getTrials());
        }

        WordDrawer.showTheEnd(trialCounter.isGameOver());
    }
}
