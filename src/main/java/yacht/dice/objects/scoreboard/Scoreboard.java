package yacht.dice.objects.scoreboard;

public class Scoreboard {
    public final int SECTION_LENGTH = ScoreboardSectionType.values().length;
    private final Integer[] SECTION_SCORE;

    public Scoreboard() {
        this.SECTION_SCORE = new Integer[SECTION_LENGTH];
        this.SECTION_SCORE[ScoreboardSectionType.SUM.getIndex()] = 0;
        this.SECTION_SCORE[ScoreboardSectionType.BONUS.getIndex()] = 0;
        this.SECTION_SCORE[ScoreboardSectionType.TOTAL.getIndex()] = 0;
    }

    public void setSectionScore(ScoreboardSectionType sectionType, int score) {
        this.SECTION_SCORE[sectionType.getIndex()] = score;
        System.out.println(this.SECTION_SCORE[sectionType.getIndex()]);

        int total = 0;
        for (int i = ScoreboardSectionType.ACES.getIndex(); i <= ScoreboardSectionType.SIXES.getIndex(); i++) {
            if (this.SECTION_SCORE[i] != null) {
                total += this.SECTION_SCORE[i];
            }
        }
        this.SECTION_SCORE[ScoreboardSectionType.SUM.getIndex()] = total;

        if (this.SECTION_SCORE[ScoreboardSectionType.SUM.getIndex()] >= 63) {
            this.SECTION_SCORE[ScoreboardSectionType.BONUS.getIndex()] = 35;
        }

        for (int i = ScoreboardSectionType.CHOICE.getIndex(); i <= ScoreboardSectionType.YACHT.getIndex(); i++) {
            if (this.SECTION_SCORE[i] != null) {
                total += SECTION_SCORE[i];
            }
        }
        this.SECTION_SCORE[ScoreboardSectionType.TOTAL.getIndex()] = total;
    }

    public Integer[] getSECTION_SCORE() {
        return SECTION_SCORE.clone();
    }

    public int getUpperSectionScore() {
        int total = 0;
        for (int i = ScoreboardSectionType.ACES.getIndex(); i <= ScoreboardSectionType.SIXES.getIndex(); i++) {
            if (this.SECTION_SCORE[i] != null) {
                total += SECTION_SCORE[i];
            }
        }
        return total;
    }

    public int getLowerSectionScore() {
        int total = 0;
        for (int i = ScoreboardSectionType.CHOICE.getIndex(); i <= ScoreboardSectionType.YACHT.getIndex(); i++) {
            if (this.SECTION_SCORE[i] != null) {
                total += SECTION_SCORE[i];
            }
        }
        return getUpperSectionScore()+ total;
    }
}