import java.util.Scanner;
import java.util.function.Function;

public class InputUtils {
    private static final Scanner scan = new Scanner(System.in);

    public static <T> T parser(Function<String, T> function) {
        while (true) {
            try {
                String input = scan.nextLine();
                return function.apply(input);
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력해주시길 바랍니다.");
                System.out.print("다시 입력: ");
            }
        }
    }
}
