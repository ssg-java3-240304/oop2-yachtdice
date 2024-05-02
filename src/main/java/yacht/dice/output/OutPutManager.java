package yacht.dice.output;

import yacht.dice.objects.DiceList;
import yacht.dice.output.ingame.dice.DiceImage;
import yacht.dice.output.ingame.socoreboard.ScoreboardImage;

import java.io.IOException;

public class OutPutManager {
    private final DiceImage DICE_IMAGE;
    private final ScoreboardImage SCOREBOARD_IMAGE;

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
//        clearConsole();
        System.out.println(this.SCOREBOARD_IMAGE.getImage(scoreboardStr));
    }

    private void printDice(DiceList dice) {
        System.out.println(this.DICE_IMAGE.getImage(dice));
    }

    //타이틀 출력
    public void printTitle(){
//        boolean[] tempKeep = new boolean[DICE_SIZE];
//        Arrays.fill(tempKeep, true);
//        Title title = new Title();
//
//        for(int j = 0 ; j < DICE_SIZE ; j++) {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                clearConsole();
//                System.out.print(drawDice.drawAnime(dice, tempKeep));
//            }
//            tempKeep[j] = false;
//        }
//        clearConsole();
//        System.out.println(drawDice.draw(dice));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        clearConsole();
//        System.out.print(title.getTitle());
    }

    /**
     * 매개변수를 지정하지 않으면 현재 객체에 저장된 데이터를 참조하여 출력함
     */
//    public void printScreen(){
//        Arrays.fill(keep,false);
//        printDice(this.dice, keep);
//    }

     /**
     * 주사위 입력을 받아 출력함
     * 주사위를 굴릴때 사용
     * @param dice
     * @param keep
     */
//    public void printScreen(int[] dice, boolean[] keep){
//        this.dice = dice;
//        this.keep = keep;
//        rollAnime(dice, keep);
//        clearConsole();
////        System.out.println(drawScoreBoard.printScoreBoard());
//        System.out.println(drawDice.draw(dice));;
//    }

    //점수판만 입력 받아 화면을 갱신하는 메소드
    //주사위는 기존 입력을 유지함
    //점수판 갱신시 사용
//    public void printScreen(String[] scoreBorad){
//        clearConsole();
////        System.out.println(drawScoreBoard.printScoreBoard());
//        System.out.println(drawDice.draw(dice));;
//    }
//



/*
    private void printScoreBoard(ScoreBoard scoreBoard){

    }
*/

//    private void printDice(int[] dice, boolean[] keep){
//        System.out.println(drawDice.draw(dice));
//    }
//
//    private void rollAnime(int[] dice, boolean[] keep){
//        for (int i = 0; i< 10; i++){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            clearConsole();
////            System.out.println(drawScoreBoard.getImage());
//            System.out.print(drawDice.drawAnime(dice, keep));
//
//        }
//    }

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
