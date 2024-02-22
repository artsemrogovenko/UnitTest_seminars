package com.average;

import java.util.List;
import java.util.NoSuchElementException;

public class AverageInformer {
    /**
     * сервис подсчета среднего значения.
     */
    private final AverageService service;

    /**
     * конструктор.
     *
     * @param averageService экземпляр сервиса подсчета
     */
    public AverageInformer(final AverageService averageService) {
        this.service = averageService;
    }

    /**
     * @param first  первый список
     * @param second второй список
     * @param <T1>   тип первого списка
     * @param <T2>   тип второго списка
     * @return сообщение
     */
    public <T1 extends Number, T2 extends Number> String compare(
            final List<T1> first, final List<T2> second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException("список не может быть null");
        }

        if (first.isEmpty() || second.isEmpty()) {
            throw new NoSuchElementException("список не должен быть пустым");
        }
        Number averageFirst = service.calculate(first);
        Number averageSecond = service.calculate(second);
        if ((double) averageFirst == (double) averageSecond) {
            return "Средние значения равны";
        }
        if ((double) averageFirst > (double) averageSecond) {
            return "Первый список имеет большее среднее значение";
        } else {
            return "Второй список имеет большее среднее значение";
        }

    }
}
