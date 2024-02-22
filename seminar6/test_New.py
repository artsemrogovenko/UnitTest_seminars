from unittest.mock import Mock

import pytest
from Tasks import Tasks


def test_find_average():
    assert Tasks.find_average([1, 5]) == 3
    assert Tasks.find_average([10, 20, 30, 40, 50]) == 30
    assert Tasks.find_average([]) == 0
    assert Tasks.find_average([5]) == 5


def test_type_error():
    with pytest.raises(TypeError):
        Tasks.find_average("6")


def test_transfer_money():
    person = Tasks.Person(1000)
    bank = Tasks.Bank()
    person.transfer_money(1000, bank)
    assert person.balance == 0
    assert bank.balance == 1000


def test_transfer_money_throw():
    person = Tasks.Person(1000)
    bank = Tasks.Bank()
    with pytest.raises(ValueError):
        person.transfer_money(2000, bank)


def test_transfer_mock():
    person = Tasks.Person(1000)
    bank_mock = Mock()

    person.transfer_money(500, bank_mock)
    bank_mock.receive_money.assert_called_with(500)


# Напишите функцию divide(a, b), которая возвращает результат деления a на b. Если b равно нулю, функция
# должна вызывать исключение ZeroDivisionError.
# Напишите тест, который проверяет, что при попытке деления на ноль функция вызывает исключение
# ZeroDivisionError.


def test_divide_zero():
    with pytest.raises(ZeroDivisionError):
        Tasks.divide(-2, 0)


# Напишите функцию multiply(a, b), которая возвращает произведение a и b.
# Затем напишите параметризованный тест, который проверяет эту функцию на нескольких наборах данных.


@pytest.mark.parametrize("a, b, expected", [
    (10, 0, 0), (2, 4, 8), (-1, 5, -5)])
def test_multiply(a, b, expected):
    assert Tasks.multiply(a, b) == expected


# Напишите тест, который проверяет,
# что встроенная функция len возвращает корректную длину строки.


@pytest.mark.parametrize("value, expected", [
    ("", 0), ("Hello!", 6), (" ", 1)
])
def test_len(value, expected):
    assert len(value) == expected


# Напишите функцию is_prime(n), которая проверяет, является ли число n простым.
# Простое число - это число, которое делится только на 1 и на себя. Напишите
# параметризованный тест с использованием pytest.mark.parametrize, который
# проверяет эту функцию на нескольких наборах данных.

@pytest.mark.parametrize('value, expected', [
    (2, True),
    (7, True),
    (11, True),
    (17, True),
    (31, True),
    (0, False)
])
def test_in_prime(value, expected):
    assert Tasks.is_prime(value) == expected
