package model;

import java.util.Arrays;
import java.util.List;

public class WordResult {

    private final String[] tiles;

    public WordResult(int wordLength, List<Integer> partialIndexes, List<Integer> perfectIndexes) {
        tiles = new String[wordLength];

        Arrays.fill(tiles, TileColor.WHITE.getEmoji());

        for (int index : partialIndexes) {
            tiles[index] = TileColor.YELLOW.getEmoji();
        }

        for (int index : perfectIndexes) {
            tiles[index] = TileColor.GREEN.getEmoji();
        }
    }

    public String[] getTiles() {
        return tiles;
    }
}
