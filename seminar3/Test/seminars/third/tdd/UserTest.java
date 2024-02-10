package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    @Test
    void authenticate() {
        User user=new User("David","1234",false);
        User user2=new User("Orin","4321",true);

        assertFalse(user.authenticate("David","213"));
        assertTrue(user.authenticate("David","1234"));

        assertTrue(user2.authenticate("Orin","4321"));
    }
}