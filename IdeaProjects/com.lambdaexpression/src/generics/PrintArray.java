package generics;

public class PrintArray {

    public static void toPrint(Integer[] inputArray) {
        for (int element : inputArray) {
            System.out.printf("%s ", element);
        }
       System.out.println();
    }

    public static void toPrint(Double[] inputArray) {
        for (double element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void toPrint(Character[] inputArray) {
        for (char element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4};
        Double[] doubleArray = {1.1, 2.5, 6.4};
        Character[] charArray = {'A', 'M', 'N'};

        PrintArray.toPrint(intArray);
        PrintArray.toPrint(doubleArray);
        PrintArray.toPrint(charArray);

    }
}
