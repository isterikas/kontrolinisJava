package lt.techin.numbers;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.test.BaseTest;

public class NumbersTest extends BaseTest {
    @Override
    protected Exercises createExercises() {
        return new NumbersImpl();
    }
}
