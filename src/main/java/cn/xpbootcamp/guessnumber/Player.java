package cn.xpbootcamp.guessnumber;

import cn.xpbootcamp.guessnumber.model.AnswerGenerator;

import java.util.Random;
import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());
        AnswerInputor answerInputor = new AnswerInputor(new Scanner(System.in));
        GameLogger gameLogger = new GameLogger();

        GameController gameController = new GameController(answerGenerator, answerInputor, gameLogger);

        gameController.play();
    }
}
