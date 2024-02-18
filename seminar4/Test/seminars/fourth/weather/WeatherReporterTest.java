package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

    /**
     * Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
     * обращающийся к внешнему API для получения информации о текущей температуре.
     * Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
     * Создайте мок-объект для WeatherService с использованием Mockito.
     */
    @Test
    void testWeatherReporter() {
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        when(weatherService.getCurrentTemperature()).thenReturn(16);

        String result = weatherReporter.generateReport();

        assertThat(result).isEqualTo("Текущая температура: " + 16 + " градусов.");
    }
}