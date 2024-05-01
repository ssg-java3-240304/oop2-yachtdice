package yacht.dice.input;

import java.util.Iterator;
import java.util.Scanner;

public class InputManager {
    Scanner sc = new Scanner(System.in);

    public String status(String input) {
        while (true) {
            if (input.equals("r"))
                break;
            else if (input.equals("w"))
                break;
            else {
                System.out.printf("잘못된 입력입니다 다시 입력해주세요 : ");
                input = sc.nextLine();
            }
        }
        return input;
    }

    public String[] checkIndex(String inputIndex) {
        String[] indexStrSplit = inputIndex.split(" ");

        for (int i = 0; i < indexStrSplit.length; i++)// 인덱스별로 for문 들어가서
        {
            while (true) {
                // 1~6사이에 없다면 다시 입력을 받고
                if (Integer.parseInt(indexStrSplit[i]) < 1 || Integer.parseInt(indexStrSplit[i]) > 6) {

                    System.out.printf("%d번째의 위치의 값이 잘못된 입력 값입니다\n", i + 1);
                    System.out.printf("1~6 사이의 값을 입력해주세요 : ");
                    indexStrSplit[i] = sc.nextLine();

                } else// 1~6 사이 값이라면 while문 탈출
                    break;
            }
        }
        return indexStrSplit;
    }

    public String CheckScoreChoice(char checkchoice) {
        String choice=null;
        do {
            switch (checkchoice) {
                case 'a':
                    System.out.println("Aces 이동");
                    choice = "Aces";
                    return choice;
                case 'b':
                    System.out.println("Deuces 이동");
                    choice = "Deuces";
                    return choice;
                case 'c':
                    System.out.println("Threes 이동");
                    choice = "Threes";
                    return choice;
                case 'd':
                    System.out.println("Fours 이동");
                    choice = "Fours";
                    return choice;
                case 'e':
                    System.out.println("Fives 이동");
                    choice = "Fives";
                    return choice;
                case 'f':
                    System.out.println("Sixes 이동");
                    choice = "Sixes";
                    return choice;
                case 'g':
                    System.out.println("Choice 이동");
                    choice = "Choice";
                    return choice;
                case 'h':
                    System.out.println("4 of a kind 이동");
                    choice = "4 of a kind";
                    return choice;
                case 'i':
                    System.out.println("Full House 이동");
                    choice = "Full House";
                    return choice;
                case 'j':
                    System.out.println("S.Straight 이동");
                    choice = "S.Straight";
                    return choice;
                case 'k':
                    System.out.println("L.Straight 이동");
                    choice = "L.straight";
                    return choice;
                case 'l':
                    System.out.println("Yacht 이동");
                    choice = "Yacht";
                    return choice;
            }
            System.out.printf("잘못입력했습니다 a~l 사이의 값을 입력해주세요 : ");
            checkchoice = sc.nextLine().charAt(0);
        } while (true);
    }
}