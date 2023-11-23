package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.addons.update.ExtendedUpdate;
import kz.pandev.legrambotapi.models.types.Update;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ezuykow
 */
public class UpdateTest {

    public static void check(List<ExtendedUpdate> updates) {
        for (Update update : updates) {
            assertTrue(update.getUpdateId() > 0);
            if (update.getMessage() != null) MessageTest.checkMessage(update.getMessage());
            if (update.getEditedMessage() != null) MessageTest.checkMessage(update.getEditedMessage());
            if (update.getInlineQuery() != null) InlineQueryTest.checkQuery(update.getInlineQuery());
            if (update.getChosenInlineResult() != null) ChosenInlineResultTest.check(update.getChosenInlineResult());
            if (update.getChannelPost() != null) MessageTest.checkMessage(update.getChannelPost());
            if (update.getEditedChannelPost() != null) MessageTest.checkMessage(update.getEditedChannelPost());
            if (update.getCallbackQuery() != null) assertNotNull(update.getCallbackQuery().getId());
            if (update.getShippingQuery() != null) assertNotNull(update.getShippingQuery().getId());
            if (update.getPreCheckoutQuery() != null) assertNotNull(update.getPreCheckoutQuery().getId());
            if (update.getPoll() != null) assertNotNull(update.getPoll().getId());
            if (update.getPollAnswer() != null) assertNotNull((update.getPollAnswer().getPollId()));
            if (update.getChatJoinRequest() != null) assertNotNull(update.getChatJoinRequest().getChat().getId());
        }
    }
}