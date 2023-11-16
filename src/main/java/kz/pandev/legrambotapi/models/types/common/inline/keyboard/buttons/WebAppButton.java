package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppInfo;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton} with <a href="https://core.telegram.org/bots/webapps">Web App</a> that will
 *       be launched when the user presses the button
 * @author ezuykow
 */
public class WebAppButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with <a href="https://core.telegram.org/bots/webapps">Web App</a> that will
     *        be launched when the user presses the button
     * @param text Label text on the button
     * @param webAppInfo Description of the <a href="https://core.telegram.org/bots/webapps">Web App</a> that will
     *      be launched when the user presses the button. The Web App will be able to send an arbitrary message
     *      on behalf of the user using the method answerWebAppQuery.
     * @apiNote Available only in private chats between a user and the bot.
     * @see WebAppInfo
     */
    public WebAppButton(@NotNull String text, @NotNull WebAppInfo webAppInfo) {
        super(text);
        webApp(webAppInfo);
    }
}