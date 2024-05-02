package yacht.dice.output.ingame.socoreboard;

import yacht.dice.objects.scoreboard.ScoreboardSectionType;

public class ScoreboardImage {
    public String getImage(String[] scoreboardStr) {
        String image = "";
        // Upper section
        image += """
            +---------------+--------+-------------+------------+------------+------------+---------+------------+-------+
            | Upper Section |  Aces  |   Deuces    |   Threes   |   Fours    |   Fives    |  Sixes  |▶ Subtotal ◀| Bonus |
            +---------------+--------+-------------+------------+------------+------------+---------+------------+-------+
            """;
        image += "| Score         |";
        image += String.format("   %-5s|", scoreboardStr[ScoreboardSectionType.ACES.getIndex()]);
        image += String.format("     %-8s|", scoreboardStr[ScoreboardSectionType.DEUCES.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.THREES.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.FOURS.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.FIVES.getIndex()]);
        image += String.format("   %-6s|", scoreboardStr[ScoreboardSectionType.SIXES.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.SUM.getIndex()]);
        image += String.format("   %-4s|", scoreboardStr[ScoreboardSectionType.BONUS.getIndex()]);
        image += '\n';
        // Lower section
        image += """
            +---------------+--------+-------------+------------+------------+------------+---------+------------+-------+
            | Select        |   a    |      b      |     c      |     d      |     e      |    f    |            |       |
            +===============+========+=============+============+============+============+=========+============+=======+
            | Lower Section | Choice | 4 of a Kind | Full House | S.Straight | L.Straight |  Yacht  |▶   Total  ◀|       |
            +---------------+--------+-------------+------------+------------+------------+---------+------------+-------+
            """;
        image += "| Score         |";
        image += String.format("   %-5s|", scoreboardStr[ScoreboardSectionType.CHOICE.getIndex()]);
        image += String.format("     %-8s|", scoreboardStr[ScoreboardSectionType.FOUR_OF_A_KIND.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.FULL_HOUSE.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.SMALL_STRAIGHT.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.LARGE_STRAIGHT.getIndex()]);
        image += String.format("   %-6s|", scoreboardStr[ScoreboardSectionType.YACHT.getIndex()]);
        image += String.format("     %-7s|", scoreboardStr[ScoreboardSectionType.TOTAL.getIndex()]);
        image += String.format("   %-4s|", ' ');
        image += '\n';
        image += """
            +---------------+--------+-------------+------------+------------+------------+---------+------------+-------+
            | Select        |   g    |      h      |     i      |     j      |     k      |    l    |            |       |
            +---------------+--------+-------------+------------+------------+------------+---------+------------+-------+
            """;
        return image;
    }
}
