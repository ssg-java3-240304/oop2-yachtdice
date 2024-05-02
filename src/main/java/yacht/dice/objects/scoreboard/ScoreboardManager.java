package yacht.dice.objects.scoreboard;

import yacht.dice.objects.DiceList;

public class ScoreboardManager {
    // singleton
    private static ScoreboardManager instance;
    public static ScoreboardManager getInstance() {
        // 이미 인스턴스가 생성되었는지 확인하고, 없으면 새로 생성하여 반환
        if(instance == null) {
            instance = new ScoreboardManager();
        }
        return instance;
    }

    // FFFFFFFFFFFFFFFFFFFField
    private final Scoreboard SCOREBOARD;

    // CCCCCCCCCCCCCCCCCCCConstructor
    public ScoreboardManager() {
        this.SCOREBOARD = new Scoreboard();
    }

    // MMMMMMMMMMMMMMMMMMMMethod
    public String[] getScoreboard(DiceList dice) {
        Integer[] sectionScore = SCOREBOARD.getSectionScore();
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

    public boolean canSetSection(ScoreboardSectionType sectionType) {
        return SCOREBOARD.getSectionScore()[sectionType.getIndex()] == null;
    }

    public void setSection(ScoreboardSectionType sectionType, DiceList dice) {
        SCOREBOARD.setSectionScore(sectionType, getSectionResult(sectionType, dice));
    }

    private int getSectionResult(ScoreboardSectionType sectionType, DiceList dice) {
        return switch (sectionType) {
            // Upper section
            case ACES -> getResultOfAces(dice);
            case DEUCES -> getResultOfDeuces(dice);
            case THREES -> getResultOfThrees(dice);
            case FOURS -> getResultOfFours(dice);
            case FIVES -> getResultOfFives(dice);
            case SIXES -> getResultOfSixes(dice);

            // Lower section
            case CHOICE -> getResultOfChoice(dice);
            case FOUR_OF_A_KIND -> getResultOfFourKind(dice);
            case FULL_HOUSE -> getResultOfFullHouse(dice);
            case SMALL_STRAIGHT -> getResultOfSmallStraight(dice);
            case LARGE_STRAIGHT -> getResultOfLargeStraight(dice);
            case YACHT -> getResultOfYacht(dice);

            default -> throw new IllegalStateException("Unexpected value: " + sectionType);
        };
    }

    // Lower section
    private int getResultOfAces(DiceList dice) {return dice.count(1);}
    private int getResultOfDeuces(DiceList dice) {return dice.count(2) * 2;}
    private int getResultOfThrees(DiceList dice) {return dice.count(3) * 3;}
    private int getResultOfFours(DiceList dice) {return dice.count(4) * 4;}
    private int getResultOfFives(DiceList dice) {return dice.count(5) * 5;}
    private int getResultOfSixes(DiceList dice) {return dice.count(6) * 6;}

    // Lower section
    private int getResultOfChoice(DiceList dice) {
        return dice.sum();
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

    private int getResultOfYacht(DiceList dice) {
        if (dice.isNumberOfKind(5)) {
            return 50;
        }
        return 0;
    }
}
