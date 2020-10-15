package cn.xpbootcamp.guessnumber;

import cn.xpbootcamp.guessnumber.model.AnswerGenerator;
import cn.xpbootcamp.guessnumber.model.GameEngine;

public class GameController {
    private GameEngine gameEngine;
    private AnswerInputor answerInputor;
    private GameLogger gameLogger;

    public GameController(AnswerGenerator answerGenerator, AnswerInputor answerInputor, GameLogger gameLogger) {
        this.gameEngine = new GameEngine(answerGenerator.generate());
        this.answerInputor = answerInputor;
        this.gameLogger = gameLogger;
    }

    /*待完成部分*/
    public void play() {

    }
}
