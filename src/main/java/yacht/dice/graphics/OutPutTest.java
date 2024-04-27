package yacht.dice.graphics;
import java.io.IOException;
import static java.lang.Thread.sleep;

/**
 *  ========
 *  콘솔 새로고침 API가 IDE상에서는 작동하지 않음
 *
 *  JAR로 빌드하여 /build/libs/oop2-yactdice-1.0-SNAPSHOT.jar을 실행해야한다
 *
 *  JAR  빌드 방법
 *  build.gradle파일에서 아래 코드를 추가하여 테스트 클래스를 메인클래스로 지정한다
 *  jar{
 *       manifest{
 *           attributes 'Main-Class': 'yacht.dice.graphics.OutPutTest'
 *       }
 *   }
 *  우측의 Gradle 탭에서 Tasks/build/jar를 실행하여 빌드하면 .jar파일이 생성됨
 *  alt + f12를 눌러 터미널을 열고 앞서 언급한 디렉토리에 접근하여 jar를 실행한다
 */

public class OutPutTest {
    public static void main(String[] args) throws InterruptedException {
        OutPutManager run = new OutPutManager();
        for (int i = 0; i < 10; i++) {
            sleep(100); //주사위가 구르는 애니메이션을 표현하기 위해 사용
/**
            콘솔 클리어
            콘솔을 지워주지 않으면 화면이 밀려 올라가는게 보이므로 굉장히 어색함
 */
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            int[] dice = {((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1)};
            //테스트용 주사위 배열 생성
            int[] dice = {5, ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1), ((int) (Math.random() * 6) + 1)};
            System.out.println();
            run.printDice(dice);    //주사위 출력
        }
    }
}
