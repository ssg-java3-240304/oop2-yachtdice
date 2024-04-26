package yacht.dice.testbed;
import yacht.dice.OutPutManager;
public class OutPutTest {
    public static void main(String[] args) {
        OutPutManager run = new OutPutManager();
        int [] dice = {2,3,4,5,6};
        run.printDIce(dice);
    }
}
