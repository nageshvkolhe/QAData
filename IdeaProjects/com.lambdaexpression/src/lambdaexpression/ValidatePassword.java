package lambdaexpression;
        import java.util.Scanner;
        import java.util.regex.Pattern;


@FunctionalInterface
interface Password {
    public abstract void ValidatePassword();
}

public class ValidatePassword {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        Password myLamda = () -> {
            String Password_Pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$" ;
            System.out.println("Enter your Password");
            String Password = sc.next();

            Pattern pa = Pattern.compile(Password_Pattern);

            if (Password.matches(Password_Pattern)) {
                System.out.println("You Entered Valid Password");
            } else {
                System.out.println("You Entered Invalid Password");
            }
        };
        myLamda.ValidatePassword();
    }
}
