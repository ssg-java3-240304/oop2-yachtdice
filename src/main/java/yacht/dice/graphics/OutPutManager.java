package yacht.dice.graphics;

import java.util.Arrays;

public class OutPutManager {
    private int[] dice;
    private DrawDice drawDice;
    private boolean[] keep;

    public boolean[] getKeep() {
        return keep;
    }

    public void setKeep(boolean[] keep) {
        this.keep = keep;
    }

    public int[] getDice() {
        return dice;
    }

    public void setDice(int[] dice) {
        this.dice = dice;
    }

    public OutPutManager() {
        this.drawDice = new DrawDice();
        this.dice = new int[5];
        this.keep = new boolean[5];
        Arrays.fill(this.dice, 6);
        Arrays.fill(this.keep, false);
    }

    /**
     * 매개변수를 지정하지 않으면 현재 객체에 저장된 데이터를 참조하여 출력함
     */
    public void printScreen(){
        Arrays.fill(keep,false);
        printDice(this.dice, keep);
    }

    /**
     * 주사위 입력을 받아 출력함
     * @param dice
     * @param keep
     */
    public void printScreen(int[] dice, boolean[] keep){
        this.dice = dice;
        this.keep = keep;
        printDice(dice, keep);
    }

    //주사위와 점수판을 입력 받아 출력함



/*
    private void printScoreBoard(ScoreBoard scoreBoard){

    }
*/

    private void printDice(int[] dice, boolean[] keep){
        System.out.println(drawDice.draw(dice, keep));
    }

}
