package yacht.dice.input;

import yacht.dice.objects.scoreboard.ScoreboardManager;
import yacht.dice.objects.scoreboard.ScoreboardSectionType;

import java.util.Scanner;

public class InputManager {
    Scanner sc = new Scanner(System.in);

    public PlayerAction getPlayerAction() {
        System.out.println("플레이어의 행동을 입력해주세요");
        System.out.print("주사위 다시 굴리기(r) / 점수판에 입력(s): ");
        char inputStr;
        PlayerAction playerAction;
        while (true) {
            try {
                inputStr = sc.nextLine().charAt(0);

                if (inputStr == 'r'){
                    playerAction = PlayerAction.REROLL_DICE;
                    break;
                }
                else if (inputStr == 's'){
                    playerAction = PlayerAction.SELECT_SCOREBOARD;
                    break;
                }
                else {
                    System.out.println("잘못된 입력입니다 다시 입력해주세요");
                    System.out.print("주사위 다시 굴리기(r) / 점수판에 입력(s): ");
                }
            }
            catch (Exception e)
            {
                // 바로 엔터를 치면 뜨는 에러를 try~catch로 잡는다
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
                System.out.print("주사위 다시 굴리기(r) / 점수판에 입력(s): ");
            }

        }
        return playerAction;
    }

    public String[] getRerollDiceIndexArray() {
        System.out.print("다시 굴릴 주사위 선택: ");
        String[] indexStrSplit = sc.nextLine().split(" ");

        for (int i = 0; i < indexStrSplit.length; i++) // 인덱스별로 for문 들어가서
        {
            while (true) {
                // 1~6사이에 없다면 다시 입력을 받고
                if (Integer.parseInt(indexStrSplit[i]) < 1 || Integer.parseInt(indexStrSplit[i]) > 6) {

                    System.out.printf("%d번째의 위치의 값이 잘못된 입력 값입니다\n", i + 1);
                    System.out.print("1~6 사이의 값을 입력해주세요 : ");
                    indexStrSplit[i] = sc.nextLine();

                } else// 1~6 사이 값이라면 while문 탈출
                    break;
            }
        }
        return indexStrSplit;
    }

    public ScoreboardSectionType getScoreboardSelect() {
        System.out.print("점수판에서 항목을 선택해주세요: ");
        ScoreboardSectionType select = null;
        char inputStr;
        do {
            inputStr = sc.nextLine().charAt(0);
            switch (inputStr) {
                case 'a':
                    System.out.println("Aces 선택");
                    select = ScoreboardSectionType.ACES;
                    break;
                case 'b':
                    System.out.println("Deuces 선택");
                    select = ScoreboardSectionType.DEUCES;
                    break;
                case 'c':
                    System.out.println("Threes 선택");
                    select = ScoreboardSectionType.THREES;
                    break;
                case 'd':
                    System.out.println("Fours 선택");
                    select = ScoreboardSectionType.FOURS;
                    break;
                case 'e':
                    System.out.println("Fives 선택");
                    select = ScoreboardSectionType.FIVES;
                    break;
                case 'f':
                    System.out.println("Sixes 선택");
                    select = ScoreboardSectionType.SIXES;
                    break;
                case 'g':
                    System.out.println("Choice 선택");
                    select = ScoreboardSectionType.CHOICE;
                    break;
                case 'h':
                    System.out.println("4 of a kind 선택");
                    select = ScoreboardSectionType.FOUR_OF_A_KIND;
                    break;
                case 'i':
                    System.out.println("Full House 선택");
                    select = ScoreboardSectionType.FULL_HOUSE;
                    break;
                case 'j':
                    System.out.println("S.Straight 선택");
                    select = ScoreboardSectionType.SMALL_STRAIGHT;
                    break;
                case 'k':
                    System.out.println("L.Straight 선택");
                    select = ScoreboardSectionType.LARGE_STRAIGHT;
                    break;
                case 'l':
                    System.out.println("Yacht 선택");
                    select = ScoreboardSectionType.YACHT;
                    break;
            }
            if (select != null) {
                if (ScoreboardManager.getInstance().canSetSection(select)) {
                    return select;
                } else {
                    System.out.print("이미 입력된 항목입니다. 다시 입력해주세요: ");
                }
            } else {
                System.out.print("잘못입력했습니다 a~l 사이의 값을 입력해주세요 : ");
            }
        } while (true);
    }
}