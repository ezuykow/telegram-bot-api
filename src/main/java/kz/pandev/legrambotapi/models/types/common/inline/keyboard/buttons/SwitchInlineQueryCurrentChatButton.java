package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton}. Pressing the button will insert the bot's username and the specified inline query
 * in the current chat's input field. May be empty, in which case only the bot's username will be inserted. This
 * offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting something
 * from multiple options.
 * @author ezuykow
 */
public class SwitchInlineQueryCurrentChatButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with switch inline query to current chat
     * @param text Label text on the button
     * @param switchInlineQueryCurrentChat pressing the button will insert the bot's username and the specified
     *                                    inline query in the current chat's input field.
     *                                    May be empty, in which case only the bot's username
     *                                    will be inserted. This offers a quick way for the user to open your
     *                                    bot in inline mode in the same chat - good for selecting something
     *                                    from multiple options.
     */
    public SwitchInlineQueryCurrentChatButton(@NotNull String text, @NotNull String switchInlineQueryCurrentChat) {
        super(text);
        switchInlineQueryCurrentChat(switchInlineQueryCurrentChat);
    }
}