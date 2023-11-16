package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.LoginUrl;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton} with an HTTPS URL used to automatically authorize the user. Can be used as a replacement
 * for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>.
 * @author ezuykow
 */
public class LoginUrlButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with an HTTPS URL used to automatically authorize the user. Can be used as a replacement
     *  for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>.
     * @param text Label text on the button
     * @param loginUrl target {@link LoginUrl}
     */
    public LoginUrlButton(@NotNull String text, @NotNull LoginUrl loginUrl) {
        super(text);
        loginUrl(loginUrl);
    }
}