package yacht.dice.scoreboard;

import yacht.dice.DiceList;

public class ScoreboardManager {
    // FFFFFFFFFFFFFFFFFFFField
    private final Scoreboard SCOREBOARD;

    // CCCCCCCCCCCCCCCCCCCConstructor
    public ScoreboardManager() {
        this.SCOREBOARD = new Scoreboard();
    }

    // MMMMMMMMMMMMMMMMMMMMethod
    public String[] getScoreboard(DiceList dice) {
        Integer[] sectionScore = SCOREBOARD.getSECTION_SCORE();
        String[] scoreboardStr = new String[SCOREBOARD.SECTION_LENGTH];
        for (int i = 0; i < SCOREBOARD.SECTION_LENGTH; i++) {
            if (sectionScore[i] != null) {
                scoreboardStr[i] = sectionScore[i].toString();
            }
            else {
                scoreboardStr[i] = "+" + getSectionResult(ScoreboardSectionType.getByIndex(i), dice);
            }
        }
        return scoreboardStr;
    }

    public void  setSection(ScoreboardSectionType sectionType, DiceList dice) {
        SCOREBOARD.setSectionScore(sectionType, getSectionResult(sectionType, dice));
    }

    private int getSectionResult(ScoreboardSectionType sectionType, DiceList dice) {
        return switch (sectionType) {
            // Upper section
            case ONES -> getResultOfOnes(dice);
            case TWOS -> getResultOfTwos(dice);
            case THREES -> getResultOfThrees(dice);
            case FOURS -> getResultOfFours(dice);
            case FIVES -> getResultOfFives(dice);
            case SIXES -> getResultOfSixes(dice);
            // Sub-counting
            case SUM -> getSum();
            case BONUS -> getBonus();

            // Lower section
            case THREE_OF_A_KIND -> getResultOfThreeKind(dice);
            case FOUR_OF_A_KIND -> getResultOfFourKind(dice);
            case FULL_HOUSE -> getResultOfFullHouse(dice);
            case SMALL_STRAIGHT -> getResultOfSmallStraight(dice);
            case LARGE_STRAIGHT -> getResultOfLargeStraight(dice);
            case YAHTZEE -> getResultOfYahtzee(dice);
            case CHANCE -> getResultOfChance(dice);
            // Total-counting
            case TOTAL -> getTotal();
        };
    }

    // Lower section
    private int getResultOfOnes(DiceList dice) {return dice.count(1);}
    private int getResultOfTwos(DiceList dice) {return dice.count(2) * 2;}
    private int getResultOfThrees(DiceList dice) {return dice.count(3 * 3);}
    private int getResultOfFours(DiceList dice) {return dice.count(4) * 4;}
    private int getResultOfFives(DiceList dice) {return dice.count(5) * 5;}
    private int getResultOfSixes(DiceList dice) {return dice.count(6) * 6;}

    private int getSum() {
        return SCOREBOARD.getUpperSectionScore();
    }

    private int getBonus() {
        if (SCOREBOARD.getUpperSectionScore() >= 63) {
            return 35;
        }
        return 0;
    }

    // Lower section
    private int getResultOfThreeKind(DiceList dice) {
        if (dice.isNumberOfKind(3)) {
            return dice.sum();
        }
        return 0;
    }

    private int getResultOfFourKind(DiceList dice) {
        if (dice.isNumberOfKind(4)) {
            return dice.sum();
        }
        return 0;
    }

    private int getResultOfFullHouse(DiceList dice) {
        if (dice.isFullHouse()) {
            return dice.sum();
        }
        return 0;
    }

    private int getResultOfSmallStraight(DiceList dice) {
        if (dice.isStraight(4)) {
            return 15;
        }
        return 0;
    }

    private int getResultOfLargeStraight(DiceList dice) {
        if (dice.isStraight(5)) {
            return 30;
        }
        return 0;
    }

    private int getResultOfYahtzee(DiceList dice) {
        if (dice.isNumberOfKind(5)) {
            return 50;
        }
        return 0;
    }

    private int getResultOfChance(DiceList dice) {
        return dice.sum();
    }

    private int getTotal() {
        return SCOREBOARD.getUpperSectionScore() + SCOREBOARD.getLowerSectionScore();
    }
}
