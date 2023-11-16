package kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons;

import kz.pandev.legrambotapi.models.types.common.SwitchInlineQueryChosenChat;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * {@link InlineKeyboardButton}. Pressing the button will prompt the user to select one of their chats
 * of the specified type, open that chat and insert the bot's username and the specified inline query
 * in the input field
 * @author ezuykow
 */
public class SwitchInlineQueryChosenChatButton extends InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * {@link InlineKeyboardButton} with switch inline query to chosen chat
     * @param text Label text on the button
     * @param switchInlineQueryChosenChat pressing the button will prompt the user to select one of their chats
     *                                   of the specified type, open that chat and insert the bot's username
     *                                   and the specified inline query in the input field
     * @see SwitchInlineQueryChosenChat
     */
    public SwitchInlineQueryChosenChatButton(@NotNull String text,
                                             @NotNull SwitchInlineQueryChosenChat switchInlineQueryChosenChat) {
        super(text);
        switchInlineQueryChosenChat(switchInlineQueryChosenChat);
    }
}