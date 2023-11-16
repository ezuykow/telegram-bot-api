package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.inline.mode.ChosenInlineResult;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class ChosenInlineResultTest {

    public static void check(ChosenInlineResult result) {
        assertNotNull(result.getResultId());
        assertNotNull(result.getQuery());
        UserTest.checkUser(result.getFrom());
    }
}