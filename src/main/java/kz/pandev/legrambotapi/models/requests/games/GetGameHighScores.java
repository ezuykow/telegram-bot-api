package kz.pandev.legrambotapi.models.requests.games;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.games.GetGameHighScoresResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get data for high score tables. Will return the score of
 * the specified user and several of their neighbors in a game. Returns an Array of GameHighScore objects.
 * @apiNote this method will currently return scores for the target user, plus two of their closest neighbors
 * on each side. Will also return the top three users if the user and their neighbors are not among them. Please
 * note that this behavior is subject to change.
 * @author ezuykow
 */
public class GetGameHighScores extends Request<GetGameHighScores, GetGameHighScoresResponse> {

    /**
     * Use if message is not an inline message
     * @param userId Target user id
     * @param chatId Unique identifier for the target chat
     * @param messageId Identifier of the sent message
     */
    public GetGameHighScores(long userId, long chatId, int messageId) {
        super(GetGameHighScoresResponse.class);
        addParameter("user_id", userId);
        addParameter("chat_id", chatId);
        addParameter("message_id", messageId);
    }

    /**
     * Use if message is an inline message
     * @param userId Target user id
     * @param inlineMessageId Identifier of the inline message
     */
    public GetGameHighScores(long userId, @NotNull String inlineMessageId) {
        super(GetGameHighScoresResponse.class);
        addParameter("user_id", userId);
        addParameter("inline_message_id", inlineMessageId);
    }
}