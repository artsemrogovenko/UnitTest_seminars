package com.average;

import java.util.List;

public class AverageService {
    /**
     * @param list список
     * @param <T> тип элементов списка
     * @return зреднее арифметическое
     */
    public <T extends Number> Number calculate(final List<T> list) {
        double result = list.get(0).doubleValue();
        for (int i = 1; i < list.size(); i++) {
            result += list.get(i).doubleValue();
        }
        return result / list.size();
    }
}
