import controller.WordInputHandler;
import model.WordComparator;
import view.FileReader;

import java.nio.file.Path;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        String todayWord = new FileReader().read(Path.of("./words.txt"));
//        System.out.println(todayWord);
//
//        WordComparator wordComparater = new WordComparator();
//
//        List<Integer> perfectMathcedInedex = wordComparater.getPerfectMathcedIndex("aaaaa", todayWord);
//        List<Integer> partialMathcedIndex = wordComparater.getPartialMatchedIndex("aaaaa", todayWord);

        WordInputHandler inputHandler = new WordInputHandler();

        inputHandler.inputWord();
    }
}
