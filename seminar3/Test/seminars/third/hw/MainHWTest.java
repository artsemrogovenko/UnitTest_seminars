package seminars.third.hw;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void init() {
        mainHW = new MainHW();
    }

    @Test
    void evenOddNumber() {
        assertTrue(mainHW.evenOddNumber(2));
        assertTrue(mainHW.evenOddNumber(0));
        assertFalse(mainHW.evenOddNumber(3));
    }

    @Test
    void numberInInterval() {
        assertTrue(mainHW.numberInInterval(25));
        assertTrue(mainHW.numberInInterval(50));
        assertFalse(mainHW.numberInInterval(24));
        assertFalse(mainHW.numberInInterval(101));
    }
}