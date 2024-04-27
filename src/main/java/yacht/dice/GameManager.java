package yacht.dice;

import java.util.Scanner;

public class GameManager {
    private static final int ROUND = 12;
    private int currentRound;
    private static final int ROLL_CHANCE = 2;
    private int currentRollChance;
    private Scoreboard scoreboard;
    private int[] dice;

    public GameManager() {
        scoreboard = new Scoreboard();
        dice = new int[6];
    }

    private Scanner sc = new Scanner(System.in);

    //
    public void start() {
        for (int i = 0; i < 1; i++) {
            this.currentRollChance = 2;
            rollAllDice();
            printAllDice();

            if (this.currentRollChance > 0) {
                if (isChoiceRollDice()) {
                    this.currentRollChance--;
                    System.out.print("give me index: ");
                    String inputStr = sc.nextLine(); // 2 3 5
                    rerollDiceAtIndex(inputStr);
                    printAllDice();
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

    //
    private void rerollDiceAtIndex(String indexStr) {
        String[] indexStrSplit = indexStr.split(" ");
        for (String index : indexStrSplit) {
            this.dice[Integer.valueOf(index) - 1] = (int) (Math.random() * 6) + 1;
        }
    }

    //
    private void printAllDice() {
        for (int die : this.dice) {
            System.out.print(die + " ");
        }
        System.out.println();
    }

    //
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
