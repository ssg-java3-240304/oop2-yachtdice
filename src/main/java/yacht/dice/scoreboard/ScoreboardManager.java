package yacht.dice.scoreboard;

public class ScoreboardManager {
    // FFFFFFFFFFFFFFFFFFFField
    private Scoreboard scoreboard;

    // CCCCCCCCCCCCCCCCCCCConstructor
    public ScoreboardManager() {
        this.scoreboard = new Scoreboard();
    }

    public String[] getScoreboard(int[] dice) {
        Integer[] sectionScore = scoreboard.getSectionScore();
        String[] scoreboardStr = new String[scoreboard.SECTION_LENGTH];
        for (int i = 0; i < scoreboard.SECTION_LENGTH; i++) {
            if (sectionScore[i] != null) {
                scoreboardStr[i] = sectionScore[i].toString();
            }
            else {
                scoreboardStr[i] = "+" + getSectionResult(ScoreboardSectionType.getByIndex(i), dice);
            }
        }
        return scoreboardStr;
    }

    // MMMMMMMMMMMMMMMMMMMMethod
    public void  setSection(ScoreboardSectionType sectionType, int[] dice) {
        scoreboard.setSectionScore(sectionType, getSectionResult(sectionType, dice));
    }

    private int getSectionResult(ScoreboardSectionType sectionType, int[] dice) {
        return switch (sectionType) {
            // Upper section
            case ONES -> getResultOfOnes(dice);
            case TWOS -> getResultOfOnes(dice);
            case THREES -> getResultOfOnes(dice);
            case FOURS -> getResultOfOnes(dice);
            case FIVES -> getResultOfOnes(dice);
            case SIXES -> getResultOfOnes(dice);
            // Sub-counting
            case SUM -> getResultOfOnes(dice);
            case BONUS -> getResultOfOnes(dice);

            // Lower section
            case THREE_OF_A_KIND -> getResultOfOnes(dice);
            case FOUR_OF_A_KIND -> getResultOfOnes(dice);
            case FULL_HOUSE -> getResultOfOnes(dice);
            case SMALL_STRAIGHT -> getResultOfOnes(dice);
            case LARGE_STRAIGHT -> getResultOfOnes(dice);
            case YAHTZEE -> getResultOfOnes(dice);
            case CHANCE -> getResultOfOnes(dice);
            // Total-counting
            case TOTAL -> getResultOfOnes(dice);
        };
    }

    private int getResultOfOnes(int[] dice) {
        return 0;
    }
}
