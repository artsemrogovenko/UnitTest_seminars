package seminars.five.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    /**
     * У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и
     * PaymentService. Класс OrderService обрабатывает заказы и делает вызовы к
     * PaymentService для обработки платежей. Ваша задача - написать интеграционный тест,
     * который проверяет, что OrderService и PaymentService взаимодействуют корректно
     */

    @Test
    void placeOrder() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("2", 20.50);

        assertTrue(result);
    }
}