package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.inline.mode.InlineQuery;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class InlineQueryTest {

    public static void checkQuery(InlineQuery inlineQuery) {
        assertNotNull(inlineQuery.getId());
        assertNotNull(inlineQuery.getFrom());
        assertNotNull(inlineQuery.getQuery());
        assertNotNull(inlineQuery.getOffset());
        UserTest.checkUser(inlineQuery.getFrom());
    }
}