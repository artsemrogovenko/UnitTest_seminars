package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
максимальное число в этом списке.
Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
тест, который проверяет, что оба модуля работают вместе правильно*/
public class RandomNumberModule {
    public ArrayList<Integer> numbers(int count) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }
}
