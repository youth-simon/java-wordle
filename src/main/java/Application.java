import view.FileReader;

import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {
        String todayWord = new FileReader().read(Path.of("word.txt"));
        System.out.println(todayWord);
    }
}
