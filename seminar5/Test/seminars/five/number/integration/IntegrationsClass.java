package seminars.five.number.integration;

import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


public class IntegrationsClass {
    @Test
    void mytest() {
        MaxNumberModule maxNumberModuleTest = new MaxNumberModule();
        RandomNumberModule randomNumberModuleTest = new RandomNumberModule();

        ArrayList<Integer> numbers = randomNumberModuleTest.numbers(10);
        Integer value = maxNumberModuleTest.maxValue(numbers);

        assertThat(value).isEqualTo(Collections.max(numbers));
    }

}
