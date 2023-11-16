package kz.pandev.legrambotapi.models.requests.games;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to set the score of the specified user in a game message. On success,
 * if the message is not an inline message, the Message is returned, otherwise True is
 * returned. Returns an error, if the new score is not greater than the user's current
 * score in the chat and force is False.
 * @author ezuykow
 */
public class SetGameScore extends Request<SetGameScore, Response> {

    /**
     * Use if the message is not an inline message
     * @param userId User identifier
     * @param score New score, must be non-negative
     * @param chatId Unique identifier for the target chat
     * @param messageId Identifier of the sent message
     */
    public SetGameScore(long userId, int score, long chatId, int messageId) {
        super(SendResponse.class);
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
     * Set parameter force
     * @param force Pass True if the high score is allowed to decrease. This can be useful when fixing
     *             mistakes or banning cheaters
     * @return this request
     */
    public SetGameScore force(boolean force) {
        return addParameter("force", force);
    }

    /**
     * Set parameter disable_edit_message
     * @param disableEditMessage Pass True if the game message should not be automatically edited to include
     *                          the current scoreboard
     * @return this request
     */
    public SetGameScore disableEditMessage(boolean disableEditMessage) {
        return addParameter("disable_edit_message", disableEditMessage);
    }

    //endregion
}