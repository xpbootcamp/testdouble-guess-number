package cn.xpbootcamp.guessnumber.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnswerTest {

    @ParameterizedTest
    @MethodSource("provideAnswerPairs")
    void should_count_correct_numbers_when_count_given_different_answers(Answer expected, Answer inputAnswer,
                                                                         int correctSum, int positionIncorrectSum) {
        assertThat(expected.countBothSame(inputAnswer)).isEqualTo(correctSum);
        assertThat(expected.countValueSame(inputAnswer)).isEqualTo(positionIncorrectSum);
    }

    private static Stream<Arguments> provideAnswerPairs() {
        return Stream.of(
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(4, 3, 2, 1), 0, 4),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(6, 7, 8, 2), 0, 1),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(6, 7, 1, 2), 0, 2),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(6, 3, 1, 2), 0, 3),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 5, 8, 9), 1, 0),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 5, 2, 7), 1, 1),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 5, 2, 3), 1, 2),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 4, 2, 3), 1, 3),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 2, 5, 0), 2, 0),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 2, 5, 3), 2, 1),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 2, 4, 3), 2, 2),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 2, 3, 0), 3, 0),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(1, 2, 3, 4), 4, 0),
                Arguments.of(Answer.of(1, 2, 3, 4), Answer.of(6, 7, 8, 9), 0, 0)
        );
    }
}
