package cn.xpbootcamp.guessnumber.model;

import cn.xpbootcamp.guessnumber.model.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerGenerator {
    private Random random;
    private static final int ANSWER_NUMBER_SIZE = 4;
    private static final int MAX_NUMBER = 9;

    public AnswerGenerator(Random random) {
        this.random = random;
    }

    public Answer generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < ANSWER_NUMBER_SIZE) {
            int number = random.nextInt(MAX_NUMBER + 1);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return Answer.of(numbers.stream().mapToInt(Integer::intValue).toArray());
    }
}
