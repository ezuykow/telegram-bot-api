package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * A pay {@link InlineKeyboardButton}.
 * @author ezuykow
 */
public class PayButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * A pay {@link InlineKeyboardButton}
     * @param text Label text on the button
     * @apiNote This type of button must always be the first button in the first row and can only be used
     * in invoice messages.
     */
    public PayButton(@NotNull String text) {
        super(text);
        pay(true);
    }
}