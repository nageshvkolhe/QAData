package lambdaexpression;
import java.util.Scanner;
import java.util.regex.Pattern;


@FunctionalInterface
interface LastName {
    public abstract void ValidateLastName();
}

public class ValidateLastName {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        LastName myLamda = () -> {
            String LastName_Pattern = "^[A-Z]{1,}([a-z]{2,})?$";

            System.out.println("Enter your Last Name");
            String LastName = sc.next();

            Pattern pa = Pattern.compile(LastName_Pattern);

            if (LastName.matches(LastName_Pattern)) {
                System.out.println("You Entered Valid Last Name");
            } else {
                System.out.println("You Entered Invalid Last Name(First letter should be in Upper Casek)");
            }
        };
        myLamda.ValidateLastName();
    }
}