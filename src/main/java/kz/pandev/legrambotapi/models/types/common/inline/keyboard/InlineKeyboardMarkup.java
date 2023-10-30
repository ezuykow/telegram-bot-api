package kz.pandev.legrambotapi.models.types.common.inline.keyboard;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class InlineKeyboardMarkup implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * List of button rows, each represented by a List of {@link InlineKeyboardButton} objects
     */
    @SerializedName("inline_keyboard")
    private List<List<InlineKeyboardButton>> inlineKeyboard;
}