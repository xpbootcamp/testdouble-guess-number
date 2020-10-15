package cn.xpbootcamp.guessnumber;


import cn.xpbootcamp.guessnumber.model.Answer;
import cn.xpbootcamp.guessnumber.exception.InvalidNumbersException;
import cn.xpbootcamp.guessnumber.exception.RepeatedNumbersException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnswerInputorTest {
    @Test
    void should_build_correct_answer_when_read_given_valid_input() {
        System.setIn(new ByteArrayInputStream("1 0 3 4".getBytes()));
        AnswerInputor answerInputor = new AnswerInputor(new Scanner(System.in));
        Answer result = answerInputor.read();
        assertThat(result).isEqualTo(Answer.of(1, 0, 3, 4));
    }

    @Test
    void should_throw_repeated_numbers_exception_when_read_given_repeated_input() {
        System.setIn(new ByteArrayInputStream("1 2 2 4".getBytes()));
        AnswerInputor answerInputor = new AnswerInputor(new Scanner(System.in));
        assertThrows(RepeatedNumbersException.class, answerInputor::read);
    }

    @Test
    void should_throw_invalid_numbers_exception_when_read_given_non_digital_number() {
        System.setIn(new ByteArrayInputStream("1 a 2 4".getBytes()));
        AnswerInputor answerInputor = new AnswerInputor(new Scanner(System.in));
        assertThrows(InvalidNumbersException.class, answerInputor::read);
    }
}
