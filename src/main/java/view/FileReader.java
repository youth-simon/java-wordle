package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FileReader {

    public static final int WORDBOOK_SIZE = 2309;

    public FileReader() {
    }

    public String read(Path path) {
        Long counter = 1L;

        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            while (!getTodayWordIndex().equals(counter)) {
                br.readLine();
                counter++;
            }
            return br.readLine();

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Long getTodayWordIndex() {
        return ChronoUnit.DAYS.between(LocalDateTime.now(), LocalDateTime.of(2021, 6, 19, 0, 0)) % WORDBOOK_SIZE;
    }
}
