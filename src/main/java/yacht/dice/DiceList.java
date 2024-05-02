package yacht.dice;

import java.util.Arrays;

public class DiceList {
    // FFFFFFFFFFFFFFFFFFFField
    private final int DICE_SIZE = 5;
    private final int[] DICE;

    // CCCCCCCCCCCCCCCCCCCConstructor
    public DiceList() {
        this.DICE = new int[DICE_SIZE];
    }

    // MMMMMMMMMMMMMMMMMMMMethod
    public int[] getList() {
        return this.DICE;
    }

    public int length() {
        return this.DICE_SIZE;
    }

    public void set(int index, int value) {
        this.DICE[index] = value;
    }

    public int get(int index) {
        return this.DICE[index];
    }

    public int count(int diceEyes) {
        int count = 0;
        for (int die : this.DICE) {
            if (die == diceEyes) {
                count++;
            }
        }
        return count;
    }

    public int sum() {
        int sum = 0;
        for (int die : this.DICE) {
            sum += die;
        }
        return sum;
    }

    public boolean isNumberOfKind(int num) {
        for (int i = 1; i <= 6; i++) {
            if (count(i) >= num) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse() {
        boolean isPair = false;
        boolean isTriple = false;
        for (int i = 1; i <= 6; i++) {
            if (count(i) == 2) {
                isPair = true;
            }
            if (count(i) == 3) {
                isTriple = true;
            }
        }
        return isPair && isTriple;
    }

    public boolean isStraight(int length) {
        int[] sortedDice  = Arrays.copyOf(this.DICE, this.DICE_SIZE);
        Arrays.sort(sortedDice );
        int straightCount = 1;
        for (int i = 0; i < sortedDice .length - 1; i++) {
            if (this.DICE[i + 1] > this.DICE[i]) {
                straightCount++;
                if (straightCount == length) {
                    return true;
                }
            }
            else {
                straightCount = 0;
            }
        }
        return false;
    }
}
