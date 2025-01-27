package lt.techin.numbers;

import lt.itakademija.exam.IntegerGenerator;

import java.util.ArrayList;

public class IntegerGeneratorImpl implements IntegerGenerator {
    private ArrayList<Integer> integers = new ArrayList<>();

    public IntegerGeneratorImpl(int i, int i1){
        for (int j=i; j<=i1; j++){
          integers.add(j);
        }
    }
    @Override
    public Integer getNext() {
        return integers.get(1);
    }
}
