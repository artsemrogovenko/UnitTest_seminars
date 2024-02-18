package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {
    /**
     * Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
     * Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
     * recipient), который отправляет сообщение получателю.
     * Вам необходимо проверить правильность работы класса NotificationService, который использует
     * MessageService для отправки уведомлений.
     */
    @Test
    void testNotificationService() {
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification("hello", "yandex.ru");

        verify(messageService, times(1)).sendMessage("hello", "yandex.ru");
    }
    @Test
    void testNotificationService2() {
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification("hello", "yandex.ru");

        verify(messageService, times(2)).sendMessage("hello", "yandex.ru");
    }
}