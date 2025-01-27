package lt.techin.numbers;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import static javax.swing.RowFilter.numberFilter;

public class FilteredIntegerGenerator implements IntegerGenerator {
    private IntegerGenerator integerGenerator;
    private NumberFilter numberFilter;

    public FilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        this.integerGenerator = integerGenerator;
        this.numberFilter = numberFilter;
    }

    @Override
    public Integer getNext() {
//        NumberFilter numberFilter1 = (numberFilter)-> ();
        return 0;
    }
}
