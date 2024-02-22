package com.average;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Создайте программу на Python или Java, которая принимает два списка чисел
 * и выполняет следующие действия:
 * принимает два списка чисел и выполняет следующие действия:
 * a. Рассчитывает среднее значение каждого списка.
 * b. Сравнивает эти средние значения и выводит соответствующее сообщение:
 * - "Первый список имеет большее среднее значение".
 * - "Второй список имеет большее среднее значение".
 * - "Средние значения равны", если средние значения списков равны.
 */
class AverageInformerTest {
    /**
     * Сервис подсчета.
     */
    private static AverageService averageService;
    /**
     * Класс для сравнения.
     */
    private static AverageInformer averageInformer;

    @BeforeAll
    static void init() {
        averageService = new AverageService();
        averageInformer = new AverageInformer(averageService);
    }

    @Test
    void testAverage() {
        final int firstInteger = 0;
        final int secondInteger = 6;
        final int four = 4;
        final double firstDouble = 1.5;
        final double secondDouble = 6.0;
        final double sumDouble = 0.0;

        List<Integer> a = Arrays.asList(firstInteger, secondInteger);
        List<Double> b = Arrays.asList(firstDouble, firstDouble, secondDouble);

        String result = averageInformer.compare(a, b);
        String result2 = averageInformer.compare(
                List.of(secondInteger), List.of(secondDouble));

        assertEquals("Средние значения равны", result);
        assertThat(result2).isEqualTo("Средние значения равны");
    }


    @Test
    void testByThrow() {
        List<Number> a = new ArrayList<>();
        List<Number> b = List.of(2);
        assertThatThrownBy(() -> averageInformer.compare(null, null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> averageInformer.compare(a, b))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void firstIsLargest() {
        final int a = 5;
        final int b = 2;
        final int c = a * b;
        String result = averageInformer.compare(List.of(a), List.of(b));
        String result2 = averageInformer.compare(List.of(c), List.of(b));

        assertThat(result)
                .isEqualTo("Первый список имеет большее среднее значение");
        assertThat(result2)
                .isEqualTo("Первый список имеет большее среднее значение");
    }

    @Test
    void secondIsLargest() {
        final int a = 5;
        final int b = 2;
        final int c = a * b;
        final int d = 7;
        String result = averageInformer.compare(List.of(b * b, d), List.of(c));
        String result2 = averageInformer.compare(List.of(a, b), List.of(c));

        assertThat(result)
                .isEqualTo("Второй список имеет большее среднее значение");
        assertThat(result2)
                .isEqualTo("Второй список имеет большее среднее значение");
    }
}
