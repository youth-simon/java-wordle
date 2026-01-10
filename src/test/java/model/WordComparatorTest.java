package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordComparatorTest {

    @Test
    @DisplayName("getPerfectMathcedIndex()에서 모든 글자가 일치할 경우 단어의 전체 인덱스를 반환한다.")
    void fullyMatch_getPerfectMathcedIndex() {
        WordComparator wordComparator = new WordComparator();

        List<Integer> perfect1 = wordComparator.getPerfectMathcedIndex("apple", "apple");
        assertEquals(perfect1, List.of(0,1,2,3,4));
    }

    @Test
    @DisplayName("getPerfectMathcedIndex()에서 특정 글자가 완전일치할 경우 완전일치하는 글자 인덱스만 반환한다.")
    void partialMatch_getPerfectMathcedIndex() {
        WordComparator wordComparator = new WordComparator();

        List<Integer> partial1 = wordComparator.getPerfectMathcedIndex("appkk", "apple");
        assertEquals(partial1, List.of(0,1,2));
    }

    @Test
    @DisplayName("getPerfectMathcedIndex()에서 완전일치하는 글자가 없을때는 빈 리스트를 반환한다.")
    void noMatch_getPerfectMathcedIndex() {
        WordComparator wordComparator = new WordComparator();

        List<Integer> noMatch1 = wordComparator.getPerfectMathcedIndex("kkkkk", "apple");
        assertEquals(noMatch1, List.of());
    }

    @Test
    @DisplayName("getPartialMatchedIndex()에서 모든 글자가 부분일치 할 경우 단어의 전체 인덱스를 반환한다.")
    void fullyMatch_getPartialMatchedIndex() {
        WordComparator wordComparator = new WordComparator();

        List<Integer> perfect1 = wordComparator.getPartialMatchedIndex("leapp", "apple");
        assertEquals(perfect1, List.of(0,1,2,3,4));
    }

    @Test
    @DisplayName("getPartialMatchedIndex()에서 특정 글자가 부분일치할 경우 부분일치하는 글자 인덱스만 반환한다.")
    void partialMatch_getPartialMatchedIndex() {
        WordComparator wordComparator = new WordComparator();

        List<Integer> partial1 = wordComparator.getPartialMatchedIndex("kkkpp", "apple");
        assertEquals(partial1, List.of(3,4));
    }

    @Test
    @DisplayName("getPartialMatchedIndex()에서 부분일치하는 글자가 없을때는 빈 리스트를 반환한다.")
    void noMatch_getPartialMatchedIndex() {
        WordComparator wordComparator = new WordComparator();

        List<Integer> noMatch1 = wordComparator.getPartialMatchedIndex("kkkkk", "apple");
        assertEquals(noMatch1, List.of());
    }
}