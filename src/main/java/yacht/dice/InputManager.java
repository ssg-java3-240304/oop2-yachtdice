package yacht.dice;

import java.util.Scanner;

public class InputManager {
    // 게임스타트, 주사위를 던진다 or 스코어 보드에 점수를 넣는다
    Scanner sc=new Scanner(System.in);
    String input =sc.next();
    public void InputManager()
    {
        System.out.printf("선택을 해주세요 1: GAMESTART, 2: 주사위 , 3: 점수창");
        InputType status=InputType.inputType(input);
        switch (status) {
            case GAMESTART -> {
                System.out.printf("게임을 재시작 합니다"); // 게임 스타트(리셋??)
            }
            case ROLL_DICE -> {
                System.out.printf("굴릴 주사위를 선택");// 굴릴 주사위 선택b
            }
            case CHOOSE_SCORE_BORAD -> {
                System.out.printf("안녕하세요");//스코어 보드로 이론
                Scoreboard scoreboard=new Scoreboard();
//                scoreboard.Scoreprint();
            }
        }
    }
}