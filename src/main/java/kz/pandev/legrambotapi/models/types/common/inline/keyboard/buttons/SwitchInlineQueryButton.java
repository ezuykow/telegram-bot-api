package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton}. Pressing the button will prompt the user to select one of their chats,
 *       open that chat and insert the bot's username and the specified inline query in the input field.
 *       May be empty, in which case just the bot's username will be inserted.
 * @author ezuykow
 */
public class SwitchInlineQueryButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with switch inline query
     * @param text Label text on the button
     * @param switchInlineQuery pressing the button will prompt the user to select one of their chats,
     *       open that chat and insert the bot's username and the specified inline query in the input field.
     *       May be empty, in which case just the bot's username will be inserted.
     */
    public SwitchInlineQueryButton(@NotNull String text, @NotNull String switchInlineQuery) {
        super(text);
        switchInlineQuery(switchInlineQuery);
    }
}