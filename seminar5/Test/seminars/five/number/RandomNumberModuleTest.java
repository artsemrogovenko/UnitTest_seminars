package seminars.five.number;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberModuleTest {

    @Test
    void numbers() {
        RandomNumberModule randomNumberModule = new RandomNumberModule();

        ArrayList<Integer> arrayList = randomNumberModule.numbers(10);

        assertThat(arrayList).hasSize(10);
    }
}