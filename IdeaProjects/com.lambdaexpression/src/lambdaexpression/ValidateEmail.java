package lambdaexpression;
        import java.util.Scanner;
        import java.util.regex.Pattern;


@FunctionalInterface
interface Email {
    public abstract void ValidateEmail();
}

public class ValidateEmail {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Email myLamda = () -> {
            String Email_Pattern = "^(?=.{1,64}@)[A-Za-z0-9]+(.[A-Za-z0-9_-]+)*@[A-Za-z0-9_-]+(.[A-Za-z0-9-]+)*(.[A-Za-z]{2,})$";

            System.out.println("Enter your Email");
            String Email = sc.next();

            Pattern pa = Pattern.compile(Email_Pattern);

            if (Email.matches(Email_Pattern)) {
                System.out.println("You Entered Valid Email");
            } else {
                System.out.println("You Entered Invalid Email");
            }
        };
        myLamda.ValidateEmail();
    }
}
