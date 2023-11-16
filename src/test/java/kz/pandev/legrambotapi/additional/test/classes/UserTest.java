package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.user.User;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class UserTest {

    public static void checkUser(User user) {
        checkUser(user, false);
    }

    public static void checkUser(User user, boolean full) {
        assertNotNull(user.getId());
        assertNotNull(user.getIsBot());
        assertNotNull(user.getFirstName());
        assertNotNull(user.getUsername());
        if (full) {
            assertNotNull(user.getLanguageCode());
        }
    }
}