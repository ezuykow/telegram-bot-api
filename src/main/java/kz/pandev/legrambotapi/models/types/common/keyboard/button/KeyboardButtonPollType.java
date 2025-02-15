package kz.pandev.legrambotapi.models.types.common.keyboard.button;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents type of poll, which is allowed to be created and sent when the
 * corresponding button is pressed
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class KeyboardButtonPollType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. If "quiz" is passed, the user will be allowed to create only polls in the quiz mode.
     * If "regular" is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create
     * a poll of any type.
     */
    @SerializedName("type")
    @Nullable
    private Poll.Type type;

    /**
     * The user will be allowed to create
     *      a poll of any type
     */
    public KeyboardButtonPollType() {}

    /**
     * If "quiz" is passed, the user will be allowed to create only polls in the quiz mode.
     *       If "regular" is passed, only regular polls will be allowed
     * @param type type of poll
     * @see Poll.Type
     */
    public KeyboardButtonPollType(@Nullable Poll.Type type) {
        this.type = type;
    }
}