package yacht.dice.output;

public class DrawPredictedResult {
    String scoreBoard = """
                +----------+------+--------+--------+-------+-------+-------+------------+--------+-------------+------------+------------+------------+-------+---------+
                | CHOICE   |  a   |    b   |   c    |   d   |   e   |   f   |            |   g    |      h      |     i      |     j      |      k     |   l   |         | 
                +----------+------+--------+--------+-------+-------+-------+------------+--------+-------------+------------+------------+------------+-------+---------+
                | CATEGORY | Aces | Deuces | Threes | Fours | Fives | Sixes |▶ SUBTOTAL ◀| Choice | 4 of a Kind | Full House | S.Straight | L.Straight | Yacht |▶ TOTAL ◀|
                +----------+------+--------+--------+-------+-------+-------+------------+--------+-------------+------------+------------+------------+-------+---------+
                | SCORE    |      |        |        |       |       |       |            |        |             |            |            |            |       |         |
                +----------+------+--------+--------+-------+-------+-------+------------+--------+-------------+------------+------------+------------+-------+---------+
                """;
}