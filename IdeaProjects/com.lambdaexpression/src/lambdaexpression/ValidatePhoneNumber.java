package lambdaexpression;
import java.util.Scanner;
import java.util.regex.Pattern;


@FunctionalInterface
interface PhoneNumber {
    public abstract void ValidatePhoneNumber();
}

public class ValidatePhoneNumber {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        PhoneNumber myLamda = () -> {
            String PhoneNumber_Pattern = "^[6-9]{1}[0-9]{9}$";

            System.out.println("Enter your PhoneNumber");
            String PhoneNumber = sc.next();

            Pattern pa = Pattern.compile(PhoneNumber_Pattern);

            if (PhoneNumber.matches(PhoneNumber_Pattern)) {
                System.out.println("You Entered Valid PhoneNumber");
            } else {
                System.out.println("You Entered Invalid PhoneNumber");
            }
        };
        myLamda.ValidatePhoneNumber();
    }
}
