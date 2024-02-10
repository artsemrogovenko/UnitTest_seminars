package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxLengthForSingleLineDescription;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private UserRepository userRepository;
    private User user1, user2, user3, user4, user5;

    @BeforeEach
    void init() {
        userRepository = new UserRepository();
        user1 = new User("David", "1234", false);
        user2 = new User("Orin", "4321", true);
        user3 = new User("Ethan", "657", false);
        user4 = new User("Patt", "789", true);
        user5 = new User("Will", "3445", true);

        user1.authenticate("David", "1234");
        user2.authenticate("Orin", "4321");
        user3.authenticate("Ethan", "657");
        user4.authenticate("Patt", "789");

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        userRepository.addUser(user4);
        userRepository.addUser(user5);//не авторизован
    }

    @Test
    void addUser() {
        assertFalse(userRepository.data.contains(user5));

        assertTrue(userRepository.data.contains(user1));
        assertTrue(userRepository.data.contains(user3));
    }


    @Test
    void clean() {
        userRepository.logout();
        userRepository.clean();

        assertTrue(userRepository.data.contains(user4));
        assertTrue(userRepository.data.contains(user2));

        assertFalse(userRepository.data.contains(user1));
        assertFalse(userRepository.data.contains(user3));

    }
}