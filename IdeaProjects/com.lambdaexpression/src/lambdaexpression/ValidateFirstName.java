package lambdaexpression;
import java.util.Scanner;
import java.util.regex.Pattern;


@FunctionalInterface
interface FirstName {
    public abstract void ValidateFirstName();
}

public class ValidateFirstName {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        FirstName myLamda = () -> {
            String FirstName_Pattern = "^[A-Z]{1,}([a-z]{2,})?$";

            System.out.println("Enter your name");
            String FirstName = sc.next();

            Pattern pa = Pattern.compile(FirstName_Pattern);

            if (FirstName.matches(FirstName_Pattern)) {
                System.out.println("You Entered Valid Name");
            } else {
                System.out.println("You Entered Invalid Name");
            }
        };
        myLamda.ValidateFirstName();
    }
}