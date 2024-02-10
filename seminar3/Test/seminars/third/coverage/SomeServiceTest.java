package seminars.third.coverage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    // 3.1.
//    @Test
//    void multipleThreeNotFiveReturnsFizz() {
//        SomeService someService = new SomeService();
//        String result = someService.fizzBuzz(6);
//        assertEquals("Fizz", result);
//    }
//
//    @Test
//    void multipleFiveNotThreeReturnsBuzz() {
//        SomeService someService = new SomeService();
//        String result = someService.fizzBuzz(10);
//        assertEquals("Buzz", result);
//    }
//
//    @Test
//    void multipleFiveteenReturnsFizzBuzz() {
//        SomeService someService = new SomeService();
//        String result = someService.fizzBuzz(30);
//        assertEquals("FizzBuzz", result);
//    }
//
//    @Test
//    void notMultipleReturnsNum() {
//        SomeService someService = new SomeService();
//        String result = someService.fizzBuzz(31);
//        assertEquals("31", result);
//    }


    SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }
// 3.1.

    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals("Fizz", someService.fizzBuzz(6));
    }

    @Test
    void multipleFiveNotThreeReturnsBuzz() {
        assertEquals("Buzz", someService.fizzBuzz(10));
    }

    @Test
    void multipleThreeAndFiveReturnsFizzBuzz() {
        assertEquals("FizzBuzz", someService.fizzBuzz(15));
    }

    @Test
    void multipleNotThreeNotFiveReturnsI() {
        assertEquals("null", someService.fizzBuzz(4));
    }

    // 3.2
    @Test
    void lastNumberIsSixReturnTrue() {
        int[] myArray = new int[]{1, 0, 1, 6};

        assertTrue(someService.firstLast6(myArray));
    }

    @Test
    void firstLastNumberNotSixReturnFalse() {
        int[] myArray = new int[]{1, 0, 1, 3};

        assertFalse(someService.firstLast6(myArray));
    }

    @Test
    void firstNumberIsSixReturnTrue() {
        int[] myArray = new int[]{6, 0, 1, 4};

        assertTrue(someService.firstLast6(myArray));
    }

    @ParameterizedTest
    @CsvSource({"2000.0, 50, 1000", "2000.0, 100, 0", "2000.0, 0, 2000"})
    void paramet(Double d, int a, int r){
        assertThat(someService.calculatingDiscount(d, a))
                .isEqualTo(r);
    }
    @ParameterizedTest
    @CsvSource({"2000.0, 101", "2000.0, -10"})
    void insufficientCoverage(Double p, int d){
        assertThatThrownBy(() ->
                someService.calculatingDiscount(p, d))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }
    @Test
    void insufficientCoverageTest() {
        System.out.println(someService.calculatingDiscount(2000.0, 10));
        assertThat(someService.calculatingDiscount(2000.0, 50)).isEqualTo(1000); // обычная скидка
        assertThat(someService.calculatingDiscount(2000.0, 100)).isEqualTo(0); // обычная скидка
        assertThat(someService.calculatingDiscount(2000.0, 0)).isEqualTo(2000); // обычная скидка


        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    @Test
    void testOneThirteen(){
        assertEquals(6, someService.luckySum(1, 2, 3));
    }
    @Test
    void testTwoThirteen() {
        assertEquals(8, someService.luckySum(13,4,4));
    }

}
