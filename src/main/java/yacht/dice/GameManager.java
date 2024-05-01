package yacht.dice;

import yacht.dice.scoreboard.ScoreboardManager;
import yacht.dice.scoreboard.ScoreboardSectionType;

import java.util.Scanner;

public class GameManager {
    private final int ROUND = 12;            // 총 라운드 = 12
    private final int ROLL_CHANCE = 2;       // 주사위를 구릴 수 있는 기회
    private final ScoreboardManager SCOREBOARD_MANAGER;    // 점수판
    private final DiceList DICE;                              // 주사위 배열

    private Scanner sc = new Scanner(System.in);

    public GameManager() {
        this.SCOREBOARD_MANAGER = new ScoreboardManager(); // scoreboard(점수판) 객체 생성
        this.DICE = new DiceList(); // 주사위 객체에 6이라는 크기 지정
    }

    // start 메소드에서 게임 라운드가 남아있을 때 주사위를 던져 출력하게 한다.
    public void start() {
        for (int i = 0; i < this.ROUND; i++) {
            // 현재 주사위를 굴릴 수 있는 남은 기회
            int currentRollChance = 2;
            rollAllDice();
            printScoreboard(); // 점수판 출력
            printAllDice(); // 굴린 주사위를 출력

            if (this.currentRollChance > 0) { // 만약 주사위를 굴릴 수 있는 기회가 있다면
                if (isChoiceRollDice()) { // 선택한 주사위가 있다면 -> isChoiceRollDice 메소드 호출
                    currentRollChance--; // 남은 라운드는 감소

                    System.out.print("give me index: ");
                    String[] inputStr = inputManager.checkIndex(sc.nextLine()); // inputManager에서 while문에서 인덱스가 맞는지 검사한다
                    rerollDiceAtIndex(inputStr); // inputStr를 매개변수로 받은 rerllDiceAtIndex메소드를 호출한다.
                    printAllDice(); // 굴린 주사위 호출
                }
                else {
                    System.out.println("writing...");
                }
            }
            else {
                System.out.println("writing...");
            }
        }
    }

    // dice 에 1~6까지 랜덤한 숫자가 들어가 있게 한다.
    private void rollAllDice() {
        for (int i = 0; i < this.DICE.length(); i++) {
            this.DICE.set(i, (int) (Math.random() * 6) + 1); // 1 ~ 6
        }
    }

    // 인덱스로 선택한 주사위만 다시 굴린다
    private void rerollDiceAtIndex(String[] indexStr) {
        String[] indexStrSplit=indexStr;
        for (String index : indexStrSplit) {
            this.DICE.set(Integer.valueOf(index) - 1, (int) (Math.random() * 6) + 1);
        }
    }

    // ====================
    // 출력
    // ====================
    // 점수판 출력
    private void printScoreboard() {
        String[] scoreboardString = SCOREBOARD_MANAGER.getScoreboard(DICE);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < scoreboardString.length / 2; i++) {
            System.out.printf("%-17s|", ScoreboardSectionType.getByIndex(i).getName());
        }
        System.out.println();
        for (int i = 0; i < scoreboardString.length / 2; i++) {
            System.out.printf("%-17s|", scoreboardString[i]);
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 8; i < scoreboardString.length; i++) {
            System.out.printf("%-17s|", ScoreboardSectionType.getByIndex(i).getName());
        }
        System.out.println();
        for (int i = 8; i < scoreboardString.length; i++) {
            System.out.printf("%-17s|", scoreboardString[i]);
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // dice 객체 배열이 die 라는 변수에 값을 할당하여 굴린 주사위를 출력한다.
    private void printAllDice() {
        for (int die : this.DICE.getList()) {
            System.out.print(die + " ");
        }
        System.out.println();
    }

    // ====================
    // 입력
    // ====================
    // 굴려진 주사위를 다시 굴릴 것인지 점수판에 입력할 것인지 선택
    private boolean isChoiceRollDice() {
        System.out.println("Reroll Dice Select 'r'");
        System.out.println("Write Scoreboard Select 'w'");
        System.out.print("enter your choice: ");
        String playerChoice = inputManager.status(sc.nextLine());// r,w인지 확인한다 아니면 계속 while으로 입력을 받음
        if (playerChoice.charAt(0) == 'r') {
            return true;
        }
        else {
            return false;
        }
    }
}
