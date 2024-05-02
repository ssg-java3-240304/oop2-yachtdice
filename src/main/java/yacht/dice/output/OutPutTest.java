package yacht.dice.output;
import java.io.IOException;
import static java.lang.Thread.sleep;

/**
 *  ========
 *  콘솔 새로고침 API가 IDE상에서는 작동하지 않음
 *  JAR로 빌드하여 /build/libs/oop2-yactdice-1.0-SNAPSHOT.jar을 실행해야한다
 *  JAR  빌드 방법
 *  build.gradle파일에서 아래 코드를 추가하여 테스트 클래스를 메인클래스로 지정한다
 *  jar{
 *       manifest{
 *           attributes 'Main-Class': 'yacht.dice.graphics.OutPutTest'
 *       }
 *   }
 *   =====주석처리 해놨습니다 주석 풀고 사용하시고 사용이 끝나고 커밋 할 때는 주석처리 하시고 커밋 하시면 됩니다======
 *  우측의 Gradle 탭에서 Tasks/build/jar를 실행하여 빌드하면 .jar파일이 생성됨
 *  alt + f12를 눌러 터미널을 열고 앞서 언급한 디렉토리에 접근하여 jar를 실행한다
 */

public class OutPutTest {
    public static void main(String[] args) throws InterruptedException {
        boolean[] keep = new boolean[]{false,false,false,false,false};
        OutPutManager outPutManager = new OutPutManager();

//            //테스트용 주사위 배열 생성
        int[] dice = {((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1)};
        keep[1] = true;
        keep[2] = true;
        keep[3] = true;
        titleTest(outPutManager);

        sleep(500);
//        rolldiceTest(dice, keep, outPutManager);
    }

    public static void titleTest(OutPutManager outPutManager){
        outPutManager.printTitle();
    }

//    public static void rolldiceTest(int[] dice, boolean[] keep, OutPutManager outPutManager){
//        outPutManager.printScreen(dice, keep);
//    }

    //콘솔클리어 하는 메소드
    public static void clearConsole(){
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}