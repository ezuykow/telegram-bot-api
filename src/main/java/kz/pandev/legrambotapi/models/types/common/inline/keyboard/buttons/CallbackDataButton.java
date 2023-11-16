package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton} with data to be sent in a callback query to the bot when button is pressed
 * @author ezuykow
 */
public class CallbackDataButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with data to be sent in a callback query to the bot when button is pressed
     * @param text Label text on the button
     * @param callbackData Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
     */
    public CallbackDataButton(@NotNull String text, @NotNull String callbackData) {
        super(text);
        callbackData(callbackData);
    }
}