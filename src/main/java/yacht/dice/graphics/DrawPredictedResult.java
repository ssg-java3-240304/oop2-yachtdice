package yacht.dice.graphics;

public class DrawPredictedResult {
    final String SCOREBOARD_TOP_PARTS = """
                +----------+------+--------+--------+-------+-------+-------+--------+-------------+------------+------------+------------+-------+
                | CATEGORY | Aces | Deuces | Threes | Fours | Fives | Sixes | Choice | 4 of a Kind | Full House | S.Straight | L.Straight | Yacht |
                +----------+------+--------+--------+-------+-------+-------+--------+-------------+------------+------------+------------+-------+""";
    final String SCOREBOARD_MID_PARTS1 = "| SCORE    |";
    final String SCOREBOARD_MID_PARTS2 = "      |        |        |       |       |       |        |             |            |            |            |       ";

    final String SCOREBOARD_BOTTOM_PARTS = """
            +----------+------+--------+--------+-------+-------+-------+--------+-------------+------------+------------+------------+-------+
            """;

    public String draw(String except, String[] scoreBoard){
        StringBuilder result = new StringBuilder();

        result.append(SCOREBOARD_TOP_PARTS);
        result.append("\n");
        result.append(drawScoreLine(except, scoreBoard));
        result.append("\n");
        result.append(SCOREBOARD_BOTTOM_PARTS);
        return result.toString();
    }

    public String drawScoreLine(String except, String[] scoreBoard){
        StringBuilder result = new StringBuilder();
        result.append(SCOREBOARD_MID_PARTS1);
        String [] scoreBox = SCOREBOARD_MID_PARTS2.split("\\|");

        for(int i = 0 ; i < scoreBox.length; i++){
            if(scoreBoard[i].startsWith("+")){
                int offset = scoreBox[i].length() / 2 + 2;
                result.append(scoreBox[i]).replace(result.length() - offset,
                        result.length() - offset + scoreBoard[i].length(),
                        scoreBoard[i]);
                result.append("|");
            }
            else{
                int offset = scoreBox[i].length() / 2;
                result.append(scoreBox[i]).replace(result.length() - offset,
                        result.length() - offset + 1,
                        "X");
                result.append("|");
            }
        }
        return result.toString();
    }
}
