package kz.pandev.legrambotapi.models.types.common.reply.keyboard;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.Keyboard;
import kz.pandev.legrambotapi.models.types.common.keyboard.button.KeyboardButton;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents a custom keyboard with reply options
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ReplyKeyboardMarkup implements Keyboard, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * List of button rows, each represented by a List of {@link KeyboardButton} objects
     */
    @SerializedName("keyboard")
    private List<List<KeyboardButton>> keyboard;

    /**
     * Optional. Requests clients to always show the keyboard when the regular keyboard is hidden.
     * Defaults to false, in which case the custom keyboard can be hidden and opened with a keyboard icon.
     */
    @SerializedName("is_persistent")
    @Nullable
    private Boolean isPersistent;

    /**
     * Optional. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller
     * if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of the
     * same height as the app's standard keyboard.
     */
    @SerializedName("resize_keyboard")
    @Nullable
    private Boolean resizeKeyboard;

    /**
     * Optional. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available,
     * but clients will automatically display the usual letter-keyboard in the chat - the user can press a special
     * button in the input field to see the custom keyboard again. Defaults to false.
     */
    @SerializedName("one_time_keyboard")
    @Nullable
    private Boolean oneTimeKeyboard;

    /**
     * Optional. The placeholder to be shown in the input field when the keyboard is active; 1-64 characters
     */
    @SerializedName("input_field_placeholder")
    @Nullable
    private String inputFieldPlaceholder;

    /**
     * Optional. Use this parameter if you want to show the keyboard to specific users only. Targets:
     * 1) users that are @mentioned in the text of the Message object;
     * 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message. <br>
     * Example: A user requests to change the bot's language, bot replies to the request with a keyboard to select
     * the new language. Other users in the group don't see the keyboard.
     */
    @SerializedName("selective")
    @Nullable
    private Boolean selective;
}