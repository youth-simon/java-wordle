package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordComparatorTest {

    @Test
    @DisplayName("완전일치 ")
    void fullyMatch_getPerfectMathcedIndex() {
        WordComparator wordComparator = new WordComparator();

        List<Integer> partial1 = wordComparator.getPerfectMathcedIndex("aaaaa", "aaaaa");
        assertEquals(partial1, List.of(0,1,2,3,4));
    }

    @Test
    @DisplayName("부분일치 ")
    void partialMatch_getPerfectMathcedIndex() {
    }

    @Test
    @DisplayName("일치하는 부분 없을때 ")
    void noMatch_getPerfectMathcedIndex() {
    }

    @Test
    @DisplayName("부분일치 일때, ")
    void partialMatch_getPartialMatchedIndex() {
    }

    @Test
    @DisplayName("일치하는 부분이 없을때, ")
    void noMatch_getPartialMatchedIndex() {
    }
}