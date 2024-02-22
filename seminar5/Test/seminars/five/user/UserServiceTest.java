package seminars.five.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    /**
     * У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для
     * получения информации о пользователе. Ваша задача - написать интеграционный тест, который
     * проверяет, что UserService и UserRepository работают вместе должным образом.
     */
    @Test
    void getUserName() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String user = userService.getUserName(2);

        assertEquals("User 2", user);

    }
}