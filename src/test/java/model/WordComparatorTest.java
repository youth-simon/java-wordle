package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WordComparatorTest {

    @Test
    @DisplayName("모든 글자가 일치하면 결과는 perfect이다")
    void fullyMatch_compare() {
        WordComparator comparator = new WordComparator();

        WordResult result = comparator.compare("apple", "apple");

        assertTrue(result.isPerfect());
    }
}