package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import kz.pandev.legrambotapi.models.types.games.CallbackGame;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton}. Will be launched the game when the user presses the button.
 * NOTE: This type of button must always be the first button in the first row.
 * @author ezuykow
 */
public class CallbackGameButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with callback game
     * @param text Label text on the button
     * @apiNote This type of button must always be the first button in the first row.
     * @see CallbackGame
     */
    public CallbackGameButton(@NotNull String text) {
        super(text);
        callbackGame(new CallbackGame());
    }
}