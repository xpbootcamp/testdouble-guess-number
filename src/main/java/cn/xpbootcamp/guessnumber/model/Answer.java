package cn.xpbootcamp.guessnumber.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Answer {
    private List<Integer> numbers = new ArrayList<>();

    public static Answer of(int... numbers) {
        Answer result = new Answer();
        Arrays.stream(numbers).forEach(number -> {
            result.numbers.add(number);
        });
        return result;
    }

    public int countBothSame(Answer inputAnswer) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(inputAnswer.numbers.get(i))) {
                sum++;
            }
        }
        return sum;
    }

    public int countValueSame(Answer inputAnswer) {
        int sum = 0;
        for (Integer number : numbers) {
            if (inputAnswer.numbers.contains(number)) {
                sum++;
            }
        }
        return sum - countBothSame(inputAnswer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(numbers, answer.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int size() {
        return numbers.size();
    }
}

