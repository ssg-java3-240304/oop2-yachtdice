package yacht.dice;

import java.util.Scanner;

public class GameManager {
    private static final int ROUND = 12; // 총 라운드 = 12
    private int currentRound; // 현재 라운드
    private static final int ROLL_CHANCE = 2; // 앞으로 남은 라운드 횟수 = 2
    private int currentRollChance; // 현재 주사위를 굴릴 수 있는 남은 기회
    private Scoreboard scoreboard;  // 점수판
    private int[] dice; // 주사위

    public GameManager() {
        scoreboard = new Scoreboard(); // scoredboard(점수판) 객체 생성
        dice = new int[6]; // 주사위 객체에 6이라는 크기 지정
    }

    private Scanner sc = new Scanner(System.in);

    // start 메소드에서 게임 라운드가 남아있을 때 주사위를 던져 출력하게 한다.
    public void start() {
        for (int i = 0; i < 1; i++) {
            this.currentRollChance = 2;
            rollAllDice(); // 주사위를 다시 던진다
            printAllDice(); // 굴린 주사위를 출력

            if (this.currentRollChance > 0) { // 만약 주사위를 굴릴 수 있는 기회가 있다면
                if (isChoiceRollDice()) { // 선택한 주사위가 있다면 -> isChoiceRollDice 메소드 호출
                    this.currentRollChance--; // 남은 라운드는 감소
                    System.out.print("give me index: ");
                    String inputStr = sc.nextLine(); // 2 3 5 // String타입에 변수 inpuStr를 인덱스로 받는다.
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

    // dice에 1~6까지 랜덤한 숫자가 들어가 있게 한다.
    private void rollAllDice() {
        for (int i = 0; i < this.dice.length; i++) {
            this.dice[i] = (int) (Math.random() * 6) + 1; // 1 ~ 6
        }
    }

    // 인덱스로 선택한 주사위만 다시 굴린다
    private void rerollDiceAtIndex(String indexStr) {
        String[] indexStrSplit = indexStr.split(" ");
        for (String index : indexStrSplit) {
            this.dice[Integer.valueOf(index) - 1] = (int) (Math.random() * 6) + 1; // this.dice[각 요소를 정수로 변환하고 -1]
        }
    }

    // dice 객체 배열이 die라는 변수에 값을 할당하여 굴린 주사위를 출력한다.
    private void printAllDice() {
        for (int die : this.dice) {
            System.out.print(die + " ");
        }
        System.out.println();
    }

    // 굴려진 주사위를 다시 굴릴 것인지 점수판에 입력할 것인지 선택
    private boolean isChoiceRollDice() {
        System.out.println("Reroll Dice Select 'r'");
        System.out.println("Write Scoreboard Select 'w'");
        System.out.print("enter your choice: ");
        String playerChoice = sc.nextLine();
        if (playerChoice.charAt(0) == 'r') {
            return true;
        }
        else {
            return false;
        }
    }
}
