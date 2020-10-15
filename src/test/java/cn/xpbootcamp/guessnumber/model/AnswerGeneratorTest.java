package cn.xpbootcamp.guessnumber.model;

import cn.xpbootcamp.guessnumber.model.Answer;
import cn.xpbootcamp.guessnumber.model.AnswerGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AnswerGeneratorTest {

    @Test
    void should_generate_random_answer_more_than_850_when_generate_1000_times() {
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());
        Set<String> answers = new HashSet<>();
        for (int j = 0; j < 1000; j++) {
            String e = answerGenerator.generate().toString();
            answers.add(e);
        }
        assertThat(answers.size()).isGreaterThan(850);
    }

    @Test
    void should_random_4_times_when_generate_given_no_repeated_numbers() {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1)
                .thenReturn(2).thenReturn(3).thenReturn(4)
                .thenReturn(5).thenReturn(5).thenReturn(6).thenReturn(9).thenReturn(7);
        Answer answer = new AnswerGenerator(random).generate();
        assertThat(answer).isEqualTo(Answer.of(1, 2, 3, 4));
        verify(random, times(4)).nextInt(10);
    }

    @Test
    void should_random_more_than_4_times_when_generate_given_repeated_numbers() {
        Random random = mock(Random.class);
        when(random.nextInt(10)).thenReturn(1)
                .thenReturn(2).thenReturn(2).thenReturn(2)
                .thenReturn(5).thenReturn(5).thenReturn(6)
                .thenReturn(9).thenReturn(7);
        Answer answer = new AnswerGenerator(random).generate();
        assertThat(answer).isEqualTo(Answer.of(1, 2, 5, 6));
        verify(random, times(7)).nextInt(10);
    }
}