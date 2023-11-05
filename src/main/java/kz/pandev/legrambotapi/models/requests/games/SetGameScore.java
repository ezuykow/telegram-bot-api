package kz.pandev.legrambotapi.models.requests.games;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to set the score of the specified user in a game message. On success,
 * if the message is not an inline message, the Message is returned, otherwise True is
 * returned. Returns an error, if the new score is not greater than the user's current
 * score in the chat and force is False.
 * @author ezuykow
 */
@Getter
public class SetGameScore extends Request<SetGameScore, Response> {

    /**
     * Optional. Pass True if the high score is allowed to decrease. This can be useful when fixing
     * mistakes or banning cheaters
     */
    @Nullable
    private Boolean force;
    /**
     * Optional. Pass True if the game message should not be automatically edited to include the current scoreboard
     */
    @Nullable
    private Boolean disableEditMessage;

    /**
     * Use if the message is not an inline message
     * @param userId User identifier
     * @param score New score, must be non-negative
     * @param chatId Unique identifier for the target chat
     * @param messageId Identifier of the sent message
     */
    public SetGameScore(long userId, int score, long chatId, int messageId) {
        super(Response.class);
        addParameter("user_id", userId);
        addParameter("score", score);
        addParameter("chat_id", chatId);
        addParameter("message_id", messageId);
    }

    /**
     * Use if the message is an inline message
     * @param userId User identifier
     * @param score New score, must be non-negative
     * @param inlineMessageId Identifier of the inline message
     */
    public SetGameScore(long userId, int score, @NotNull String inlineMessageId) {
        super(Response.class);
        addParameter("user_id", userId);
        addParameter("score", score);
        addParameter("inline_message_id", inlineMessageId);
    }

    //region API

    /**
     * Set parameter {@link SetGameScore#force}
     * @param force new parameter value
     * @return this request
     */
    public SetGameScore force(boolean force) {
        this.force = force;
        return addParameter("force", force);
    }

    /**
     * Set parameter {@link SetGameScore#disableEditMessage}
     * @param disableEditMessage new parameter value
     * @return this request
     */
    public SetGameScore disableEditMessage(boolean disableEditMessage) {
        this.disableEditMessage = disableEditMessage;
        return addParameter("disable_edit_message", disableEditMessage);
    }

    //endregion
}