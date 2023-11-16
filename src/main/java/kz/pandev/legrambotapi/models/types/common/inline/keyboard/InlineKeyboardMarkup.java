package kz.pandev.legrambotapi.models.types.common.inline.keyboard;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.Keyboard;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InlineKeyboardMarkup implements Keyboard, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * List of button rows, each represented by a List of {@link InlineKeyboardButton} objects
     */
    @SerializedName("inline_keyboard")
    private List<List<InlineKeyboardButton>> inlineKeyboard;

    private InlineKeyboardMarkup() {
        this.inlineKeyboard = new ArrayList<>();
    }

    public InlineKeyboardMarkup(@NotNull InlineKeyboardButton... keyboard) {
        this(Arrays.asList(keyboard));
    }

    public InlineKeyboardMarkup(@NotNull List<InlineKeyboardButton> keyboard) {
        this();
        this.inlineKeyboard.add(keyboard);
    }

    public InlineKeyboardMarkup(@NotNull InlineKeyboardButton[]... keyboard) {
        this();
        for (InlineKeyboardButton[] row : keyboard) {
            addRow(row);
        }
    }

    @SafeVarargs
    public InlineKeyboardMarkup(@NotNull List<InlineKeyboardButton>... keyboard) {
        this();
        for (List<InlineKeyboardButton> row : keyboard) {
            addRow(row);
        }
    }

    //region API

    /**
     * Add row to keyboard
     * @param rowButtons row to add
     * @return this
     */
    public InlineKeyboardMarkup addRow(InlineKeyboardButton... rowButtons) {
        return addRow(Arrays.asList(rowButtons));
    }

    /**
     * Add row to keyboard
     * @param rowButtons row to add
     * @return this
     */
    public InlineKeyboardMarkup addRow(List<InlineKeyboardButton> rowButtons) {
        this.inlineKeyboard.add(rowButtons);
        return this;
    }

    //endregion
}