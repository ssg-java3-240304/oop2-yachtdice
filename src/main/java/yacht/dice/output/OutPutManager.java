package yacht.dice.output;

import yacht.dice.objects.DiceList;
import yacht.dice.output.ingame.dice.DiceImage;
import yacht.dice.output.ingame.socoreboard.ScoreboardImage;

import java.io.IOException;
import java.util.Arrays;

public class OutPutManager {
    private final DiceImage DICE_IMAGE;
    private final ScoreboardImage SCOREBOARD_IMAGE;
    private final int PRINT_OFFSET = 15;

    //constructor
    public OutPutManager() {
        this.DICE_IMAGE = new DiceImage();
        this.SCOREBOARD_IMAGE = new ScoreboardImage();
    }

    public void pintCurrentRound(int round) {
        System.out.println("Current round: " + round);
    }

    public void printScreen(String[] scoreboardStr, DiceList dice) {
        printScoreboard(scoreboardStr);
        printDice(dice);
    }

    public void printScoreboard(String[] scoreboardStr) {
        System.out.println(this.SCOREBOARD_IMAGE.getImage(scoreboardStr));
    }

    private void printDice(DiceList dice) {
        System.out.println(addOffset(this.DICE_IMAGE.getImage(dice), PRINT_OFFSET));
    }

    //타이틀 출력

    /**
     * 주사위 입력을 받아 출력함
     * 주사위를 굴릴때 사용
     * @param dice
     * @param rerolledDice
     */
    public void printScreen(String[] scoreboardStr, DiceList dice, String[] rerolledDice, int round){
        rollAnime(scoreboardStr, dice, rerolledDice, round);
        clearConsole();
        pintCurrentRound(round);
        printScoreboard(scoreboardStr);
        System.out.println(addOffset(this.DICE_IMAGE.getImage(dice), PRINT_OFFSET));
    }

    public void printScreenAll(String[] scoreboardStr, DiceList dice, int round){
        String[] rerolledDice = {"1","2","3","4","5"};
        rollAnime(scoreboardStr, dice, rerolledDice, round);
        clearConsole();
        pintCurrentRound(round);
        printScoreboard(scoreboardStr);
        System.out.println(addOffset(this.DICE_IMAGE.getImage(dice), PRINT_OFFSET));
    }

    public void printTitle(){
        Title title = new Title();

        clearConsole();
        System.out.println('\n');
        System.out.println('\n');
        System.out.print(addOffset(title.getTitle(), PRINT_OFFSET+5));
    }

    private void rollAnime(String[] scoreboardStr, DiceList dice, String[] rerolledDice, int round){
        for (int i = 0; i< 10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clearConsole();
            pintCurrentRound(round);
            printScoreboard(scoreboardStr);
            System.out.println(addOffset(this.DICE_IMAGE.getRandomDice(dice, rerolledDice), PRINT_OFFSET));

        }
    }



    private String addOffset(String diceStr, int offset){
        StringBuilder result = new StringBuilder();
        String[] diceSubStr = diceStr.split("\n");
        for(String subStr : diceSubStr){
            result.append(" ".repeat(offset));
            result.append(subStr);
            result.append("\n");
        }
        return result.toString();
    }


    private static void clearConsole(){
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
