package yacht.dice.objects.scoreboard;

public enum ScoreboardSectionType {
    // Upper section
    ACES(0, "Ones"),
    DEUCES(1, "Twos"),
    THREES(2, "Threes"),
    FOURS(3, "Fours"),
    FIVES(4, "Fives"),
    SIXES(5, "Sixes"),
    SUM(6, "Sum"),
    BONUS(7, "Bonus"),

    // Lower section
    CHOICE(8, "Choice"),
    FOUR_OF_A_KIND(9, "Four of a Kind"),
    FULL_HOUSE(10, "Full House"),
    SMALL_STRAIGHT(11, "Small Straight"),
    LARGE_STRAIGHT(12, "Large Straight"),
    YACHT(13, "Yacht"),
    TOTAL(15, "TOTAL");

    private final int index;
    private final String name;

    ScoreboardSectionType(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }


    public static ScoreboardSectionType getByIndex(int index) {
        for (ScoreboardSectionType section : ScoreboardSectionType.values()) {
            if (section.getIndex() == index) {
                return section;
            }
        }
        throw new IllegalArgumentException("No such section with index: " + index);
    }
}
