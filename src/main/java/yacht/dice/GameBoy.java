package yacht.dice;

import yacht.dice.input.InputManager;
import yacht.dice.objects.DiceList;
import yacht.dice.objects.scoreboard.ScoreboardManager;
import yacht.dice.output.OutPutManager;

public class GameBoy {
    private final InputManager INPUT_MANAGER;               // 입력 담당
    private final OutPutManager OUTPUT_MANAGER;             // 출력 담당

    private final int ROUND = 12;                           // 총 라운드 = 12
    private final int REROLL_CHANCE = 2;                    // 주사위를 다시 굴릴수 있는 기회
    private final ScoreboardManager SCOREBOARD_MANAGER;     // 점수판
    private final DiceList DICE;                            // 주사위 리스트

    public GameBoy() {
        this.INPUT_MANAGER = new InputManager();
        this.OUTPUT_MANAGER = new OutPutManager();
        this.SCOREBOARD_MANAGER = ScoreboardManager.getInstance();
        this.DICE = new DiceList();
    }

    // start: 게임 로비
    public void start() {
        // 로비화면 출력
        gameStart();
    }

    public void gameStart() {
        for (int i = 0; i < this.ROUND; i++) {
            OUTPUT_MANAGER.pintCurrentRound(i + 1);
            rollAllDice();
            OUTPUT_MANAGER.printScreen(SCOREBOARD_MANAGER.getScoreboard(DICE), DICE);

            int currentRerollChance = this.REROLL_CHANCE;
            playerAction:
            while (true) {
                if (currentRerollChance > 0) {
                    switch (INPUT_MANAGER.getPlayerAction()) { // 플레이어 선택 받기
                        case REROLL_DICE: // 리롤 선택시
                            currentRerollChance--;
                            rerollDiceAtIndex(INPUT_MANAGER.getRerollDiceIndexArray());
                            OUTPUT_MANAGER.pintCurrentRound(i + 1);
                            OUTPUT_MANAGER.printScreen(SCOREBOARD_MANAGER.getScoreboard(DICE), DICE);
                            break;

                        case SELECT_SCOREBOARD: // 점수판 입력 선택시
                            SCOREBOARD_MANAGER.setSection(INPUT_MANAGER.getScoreboardSelect(), DICE);
                            break playerAction;
                    }
                } else { // 리롤 기회 없을 경우 점수판 입력
                    SCOREBOARD_MANAGER.setSection(INPUT_MANAGER.getScoreboardSelect(), DICE);
                    break;
                }
            }
        }
        OUTPUT_MANAGER.printScoreboard(SCOREBOARD_MANAGER.getScoreboard());
    }

    // dice 에 1~6까지 랜덤한 숫자가 들어가 있게 한다.
    private void rollAllDice() {
        for (int i = 0; i < this.DICE.length(); i++) {
            this.DICE.set(i, (int) (Math.random() * 6) + 1); // 1 ~ 6
        }
    }

    // 인덱스로 선택한 주사위만 다시 굴린다
    private void rerollDiceAtIndex(String[] indexStrSplit) {
        for (String index : indexStrSplit) {
            this.DICE.set(Integer.valueOf(index) - 1, (int) (Math.random() * 6) + 1);
        }
    }
}
