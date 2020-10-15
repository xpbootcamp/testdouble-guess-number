package cn.xpbootcamp.guessnumber;

import cn.xpbootcamp.guessnumber.model.Answer;
import cn.xpbootcamp.guessnumber.exception.InvalidNumbersException;
import cn.xpbootcamp.guessnumber.exception.RepeatedNumbersException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnswerInputor {
    private Scanner scanner;

    public AnswerInputor(Scanner scanner) {
        this.scanner = scanner;
    }

    public Answer read() {
        String line = scanner.nextLine();
        List<Integer> lineNumbers = new ArrayList<>();
        for (String number : line.split(" ")) {
            if (!number.matches("\\d+")) {
                throw new InvalidNumbersException();
            }
            lineNumbers.add(Integer.valueOf(number));
        }
        int distinctSize = lineNumbers.stream().distinct().collect(Collectors.toList()).size();
        if (distinctSize < lineNumbers.size()) {
            throw new RepeatedNumbersException();
        }
        return Answer.of(lineNumbers.stream().mapToInt(Integer::intValue).toArray());
    }
}
