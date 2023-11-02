package kz.pandev.legrambotapi;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Use this method to get data for high score tables. Will return the score of
 * the specified user and several of their neighbors in a game. Returns an Array of GameHighScore objects.
 * @apiNote this method will currently return scores for the target user, plus two of their closest neighbors
 * on each side. Will also return the top three users if the user and their neighbors are not among them. Please
 * note that this behavior is subject to change.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GetGameHighScores implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Target user id
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Required if inline_message_id is not specified. Unique identifier for the target chat
     */
    @SerializedName("chat_id")
    @Nullable
    private Integer chatId;

    /**
     * Required if inline_message_id is not specified. Identifier of the sent message
     */
    @SerializedName("message_id")
    @Nullable
    private Integer messageId;

    /**
     * Required if chat_id and message_id are not specified. Identifier of the inline message
     */
    @SerializedName("inline_message_id")
    @Nullable
    private String inlineMessageId;
}