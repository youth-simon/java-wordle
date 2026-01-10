package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FileReader {

    public static final int WORDBOOK_SIZE = 2309;

    public FileReader() {
    }

    public String read(Path path) {
        Long counter = 1L;
        try (InputStream is = FileReader.class.getClassLoader().getResourceAsStream("words.txt")) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                while (!getTodayWordIndex().equals(counter)) {
                    br.readLine();
                    counter++;
                }
                return br.readLine();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        private static Long getTodayWordIndex () {

            return ChronoUnit.DAYS.between(LocalDateTime.of(2021, 6, 19, 0, 0), LocalDateTime.now()) % WORDBOOK_SIZE;
        }

}
