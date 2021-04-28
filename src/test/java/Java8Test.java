import com.practice.allcollections.entity.Customer;
import com.practice.allcollections.service.MyMath;
import com.practice.allcollections.service.MySum;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Test {

    @Test
    public void java8() {

        List<String> strings = Arrays.asList("A", "B", "C");

        strings.stream().map(String::toUpperCase)
                .collect(Collectors.joining(":"));

        List<Integer> numbers = Arrays.asList(10, 2, 3, 4, 6);

        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();

        stats.getCount();
        stats.getAverage();


        Function<Integer, Integer> f = (a) -> a ;
        int r = f.apply(1);

        Consumer<Integer> c = (a) -> new Customer().setId(a);
        Consumer<Integer> c1 = new Customer()::setId;
        c.accept(1);
        c1.accept(1);

        MyMath myMath = (a) -> 2 * a;


        myMath.getDoubleOf(4);

        myMath.print("");
        MyMath.print("", 1);

        MySum mySum = (a, b) -> a + b;

        mySum.getSumOf(1, 2);

        MySum mySum1 = (x, y) -> {
            int sum = x + y;
            return sum;
        };

        mySum1.getSumOf(1, 2);

        Predicate<Integer> predicate = a -> a == 2;
        predicate.test(2);


    }

}
