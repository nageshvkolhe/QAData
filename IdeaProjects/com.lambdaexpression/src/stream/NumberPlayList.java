package stream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0;i < 7; i++) myNumberList.add(i);

        //method 1: Transversing using Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Mth1: Iterator Value::" + i);
        }

        //method 2: Transversing with Explicit consumer interface implementation
        class Myconsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("Mth2: Consumer impl Value::" + t);
            }
        }
        Myconsumer action = new Myconsumer();
        myNumberList.forEach(action);

        //method 3: Transversing with Anonymous consumer interface implements
        myNumberList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("Mth3: forEach anonymous class value:" + t);
            }
        });

        //method 4: Explicit Lambda Expression
        Consumer<Integer> myListAction = n -> {
            System.out.println("Mth4: forEach Lambda impl value::" + n);
        };
        myNumberList.forEach(myListAction);

        //method 5: Implicit Lambda Expression
        myNumberList.forEach(n -> {
            System.out.println("Mth5: forEach Lambda impl value::" + n);
        });

        //method 6: Implicit Lambda Function to print double value
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n -> {
            System.out.println("Mth6: forEach Lambda double value::" +
                    toDoubleFunction.apply(n));
        });

        //method 7: Implicit Lambda Function to check even
        Predicate<Integer> isEvenFunction = n -> n > 0 && n%2 == 0;
        myNumberList.forEach(n -> {
            System.out.println("Mth7: forEach value of:" + n +
                    "check for Even:" + isEvenFunction.test(n));
        });

        //method 8: Processing the list
        myNumberList.stream().forEach( n -> {
            System.out.println("Mth8: forEach value :" + n );
        });

        //method 9: Process the stream , apply operations on the stream and then store the result
        List<Double>streamList = myNumberList.stream()
                                 .filter(isEvenFunction)
                                 .peek(n-> System.out.println("Peak Even Number :" +n))
                                 .map(toDoubleFunction)
                                 .collect(Collectors.toList());
        System.out.println("Mth9: Printing Double List :" + streamList);

        //method 10: Listing the first Even
        Integer First = myNumberList.stream()
                     .filter(isEvenFunction)
                     .peek(n-> System.out.println("Peak Even Number :" +n))
                     .findFirst()
                     .orElse(null);
        System.out.println("Mth10: First Even: " +First);

        //method 11: Minimum Even numbers
        Integer min =myNumberList.stream()
                     .filter(isEvenFunction)
                     .min((n1, n2) -> n1-n2)
                     .orElse(null);
        System.out.println("Mth11: Min Even :" + min);

        //method 12: Maximum Even numbers
        Integer max =myNumberList.stream()
                    .filter(isEvenFunction)
                    .max(Comparator.comparing(Integer::intValue))
                    .orElse(null);
        System.out.println("Mth11: Max Even :" + max);

        //method 13: sum,count and average of numbers
        Integer sum = myNumberList.stream()
                      .reduce(0,Integer::sum);
        long count = myNumberList.stream().count();
        System.out.println("Mth13: Avg of " +sum+"/"+count+"="+sum/count);
    }
}