package yacht.dice.graphics;
import yacht.dice.scoreboard.ScoreboardSectionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawPredictedResult {
    final String SCOREBOARD_TOP_PARTS = """
                +----------+------+--------+--------+-------+-------+------<< Score Preview >>-----+------------+------------+------------+-------+
                | CATEGORY | Aces | Deuces | Threes | Fours | Fives | Sixes | Choice | 4 of a Kind | Full House | S.Straight | L.Straight | Yacht |
                +----------+------+--------+--------+-------+-------+-------+--------+-------------+------------+------------+------------+-------+""";
    final String SCOREBOARD_MID_PARTS1 = "| SCORE    |";
    final String SCOREBOARD_MID_PARTS2 = "      |        |        |       |       |       |        |             |            |            |            |       ";

    final String SCOREBOARD_BOTTOM_PARTS = """
            +----------+------+--------+--------+-------+-------+-------+--------+-------------+------------+------------+------------+-------+
            """;

    public String draw(String[] scoreBoard){
        StringBuilder result = new StringBuilder();

        result.append(SCOREBOARD_TOP_PARTS);
        result.append("\n");
        result.append(drawScoreLine(scoreBoard));
        result.append("\n");
        result.append(SCOREBOARD_BOTTOM_PARTS);
        return result.toString();
    }

    public String drawScoreLine(String[] scoreBoard){
        StringBuilder result = new StringBuilder();
        String[] predictBoard = scoreBoard;
        result.append(SCOREBOARD_MID_PARTS1);

        String [] scoreBox = SCOREBOARD_MID_PARTS2.split("\\|");
        predictBoard = rmScoreBoardElement(scoreBoard); //socreBoard에서 불필요한 요소 제거

        for(int i = 0 ; i < scoreBox.length; i++){
            if(predictBoard[i].startsWith("+")){
                int offset = scoreBox[i].length() / 2 + 2;
                result.append(scoreBox[i]).replace(result.length() - offset,
                        result.length() - offset + predictBoard[i].length(),
                        predictBoard[i]);
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

    private String[] rmScoreBoardElement(String[] scoreBoard){
        String[] predictBoard;
        //스코어 보드에서 sum, bonus, total을 제거하기 위해 리스트로 변환
        List<String> scoreList = new ArrayList<>(Arrays.asList(scoreBoard));
        //TOTAL, BONUS, SUM 제거
        scoreList.remove(ScoreboardSectionType.TOTAL.getIndex());
        scoreList.remove(ScoreboardSectionType.BONUS.getIndex());
        scoreList.remove(ScoreboardSectionType.SUM.getIndex());

        //리스트를 배열로 다시 변환
        predictBoard = scoreList.toArray(new String[0]);
        return predictBoard;
    }
}
