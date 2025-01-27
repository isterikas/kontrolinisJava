package lt.techin.numbers;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;
import java.util.stream.IntStream;

import static javax.swing.RowFilter.numberFilter;

public class NumbersImpl implements Exercises {
    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().min((a, b) -> a - b).orElse(null);
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream().max((a, b) -> a - b).orElse(null);
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return o == o1;
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        return List.of();
    }

    @Override
    public int computeSumOfNumbers(int i) {
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            sum += j;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int i, NumberFilter numberFilter) {
        int sum = 0;
        for (int j = 0; j <= i; j++) {
            if (numberFilter.accept(j)) {
                sum += j;
            }
        }
        return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int i) {
        List<Integer> numbers = new ArrayList<>();
        for (int j = 1; j < i; j++) {
            numbers.add(j);
        }
        return numbers;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        Map<Integer, Integer> occurences = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (occurences.containsKey(list.get(i))) {
                occurences.put(list.get(i), occurences.get(list.get(i)) + 1);
            } else {
                occurences.put(list.get(i), 1);
            }
        }
        return occurences;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {

        return (x) -> x==i? i+1 : i;
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return null;
    }
}
