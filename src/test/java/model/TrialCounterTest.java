package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrialCounterTest {

    @Nested
    @DisplayName("increment 관련 테스트")
    class IncrementTest {
        @Test
        @DisplayName("increment를 한 번 호출하면 trials는 1이다")
        void incrementOnce() {
            //given
            final TrialCounter trialCounter = new TrialCounter();

            //when
            trialCounter.increment();

            //then
            assertThat(trialCounter.getTrials()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("keepTrying 관련 테스트")
    class KeppTryingTests {
        @Test
        @DisplayName("trials가 6이면 keepTrying은 false다")
        void keepTryingIsFalseAtLimit() {
            //given
            TrialCounter counter = TrialCounter.withTrials(6);

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("trials가 5이면 keepTrying은 true다")
        void keepTryingIsTrueWhenTrialsUnderLimit() {
            //given
            TrialCounter counter = TrialCounter.withTrials(5);

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("trials가 6회를 초과하면 keepTrying은 false다")
        void keepTryingIsFalseWhenTrialsExceeded() {
            //given
            TrialCounter counter = TrialCounter.withTrials(7);

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("gameOver 관련 테스트")
    class GameOverTests {
        @Test
        @DisplayName("gameOver이면 trials가 남아있어도 keepTrying은 false다")
        void keepTryingIsFalseWhenGameOver() {
            //given
            TrialCounter counter = TrialCounter.withTrials(0);
            counter.gameOver();

            //when
            boolean result = counter.keepTrying();

            //then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("gameOver를 호출하면 게임 종료 상태가 된다")
        void gameOverSetsFlag() {
            //given
            TrialCounter counter = new TrialCounter();

            //when
            counter.gameOver();

            //then
            assertThat(counter.isGameOver()).isTrue();
        }
    }

    @Nested
    @DisplayName("withTrials 관련 테스트")
    class WithTrialsTests {
        @Test
        @DisplayName("withTrials로 생성하면 trials가 설정된다")
        void withTrialsFactory() {
            //given & when
            TrialCounter counter = TrialCounter.withTrials(3);

            //then
            assertThat(counter.getTrials()).isEqualTo(3);
        }
    }
}