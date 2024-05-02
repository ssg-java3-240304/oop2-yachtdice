package yacht.dice.output.ingame.dice;

import yacht.dice.objects.DiceList;

/**
 * 주사위는 총 6줄로 그린다
 * 상단 2줄과 마지막 1줄은 항상 고정
 * 3번, 4번, 5번 라인을 동적으로 구성
 * 중복되는 패턴 제거
 * 주사위 패턴 |           |  |   *       | |     *     | |       *   | |   *   *   |
 * <p>
 * 5개 패턴으로 표현 가능
 * - 주사위 1 = 0 2 0
 * - 주사위 2 = 1 0 3
 * - 주사위 3 = 1 2 3
 * - 주사위 4 = 4 0 4
 * - 주사위 5 = 4 1 4
 * - 주사위 6 = 4 4 4
 * <p>
 * 위치 + 눈의 값 조합을 입력으로 받는 메소드 작성
 * 각 주사위마다 현재 출력해야할 라인을 식별함
 */

public class DiceImage {
    private final String[] diceParts = {"|           |", "|   *       |", "|     *     |", "|       *   |", "|   *   *   |"};
    private final String dicetop = """
             ___________     ___________     ___________     ___________     ___________ 
            |           |   |           |   |           |   |           |   |           |
            """;
    private final String dicebottom = """
            |___________|   |___________|   |___________|   |___________|   |___________|
            """;

    /**
     * keep이 설정되지 않은 주사위만 굴러가는 애니메이션용
     *
     * @param dice
     * @param keep
     */
    public String drawDiceAnime(DiceList dice, boolean[] keep) {
        StringBuilder diceBuilder = new StringBuilder();
        DiceList tempDice = dice.getClone();
        for (int i = 0; i < keep.length; i++) {
            if (keep[i]) {
                tempDice.set(i, (int) (Math.random() * 6 + 1));
            }
        }
        return getImage(tempDice);
    }


    /**
     * 모든 주사위에 굴림 애니메이션 출력 메소드
     *
     * @param dice
     * @return 완성된 주사위 5개 이미지 반환
     */
    public String getImage(DiceList dice) {
        StringBuilder diceBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++)
                diceBuilder.append(drawDiceParts(i + 1, dice.get(j)));
            diceBuilder.append("\n");
        }
        return dicetop + diceBuilder + dicebottom;
    }

    private String drawDiceParts(int line, int diceEyes) {

        StringBuilder result = new StringBuilder();
        switch (line) {
            case 1:
                if (diceEyes >= 4) {
                    result.append(diceParts[4]);
                } else if (1 < diceEyes) {
                    result.append(diceParts[1]);
                } else if (diceEyes == 1) {
                    result.append(diceParts[0]);
                }
                break;
            case 2:
                if (diceEyes == 6) {
                    result.append(diceParts[4]);
                } else if (diceEyes % 2 == 0) {
                    //짝수면 0
                    result.append(diceParts[0]);
                } else if (diceEyes % 2 == 1) {
                    //홀수면 1
                    result.append(diceParts[2]);
                }
                break;
            case 3:
                if (diceEyes >= 4) {
                    result.append(diceParts[4]);
                } else if (1 < diceEyes) {
                    result.append(diceParts[3]);
                } else if (diceEyes == 1) {
                    result.append(diceParts[0]);
                }
                break;
            default:
                break;
        }
        return result.append("   ").toString();
    }
}
