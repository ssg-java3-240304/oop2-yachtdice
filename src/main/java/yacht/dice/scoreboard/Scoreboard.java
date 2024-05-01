package yacht.dice.scoreboard;

public class Scoreboard {
    public final int SECTION_LENGTH = ScoreboardSectionType.values().length;
    private Integer[] sectionScore;

    public Scoreboard() {
        this.sectionScore = new Integer[SECTION_LENGTH];
        this.sectionScore[ScoreboardSectionType.SUM.getIndex()] = 0;
        this.sectionScore[ScoreboardSectionType.BONUS.getIndex()] = 0;
        this.sectionScore[ScoreboardSectionType.TOTAL.getIndex()] = 0;
    }

    public void setSectionScore(ScoreboardSectionType sectionType, int score) {
        this.sectionScore[sectionType.getIndex()] = score;
    }

    public Integer[] getSectionScore() {
        return sectionScore.clone();
    }
}