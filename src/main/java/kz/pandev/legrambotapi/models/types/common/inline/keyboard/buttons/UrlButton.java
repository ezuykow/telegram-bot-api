package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton} with HTTP or tg:// URL to be opened when the button is pressed.
 * Links tg://user?id=  can be used to mention a user by their ID without using a username,
 * if this is allowed by their privacy settings
 * @author ezuykow
 */
public class UrlButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with HTTP or tg:// URL to be opened when the button is pressed.
     * Links tg://user?id=  can be used to mention a user by their ID without using a username,
     * if this is allowed by their privacy settings
     * @param text Label text on the button
     * @param url target URL
     */
    public UrlButton(@NotNull String text, @NotNull String url) {
        super(text);
        url(url);
    }
}