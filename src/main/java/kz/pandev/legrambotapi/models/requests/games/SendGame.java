package kz.pandev.legrambotapi.models.requests.games;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send a game. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendGame extends AbstractSendRequest<SendGame> {

    /**
     * @param chatId Unique identifier for the target chat
     * @param gameShortName Short name of the game, serves as the unique identifier for the game.
     */
    public SendGame(@NotNull Long chatId, @NotNull String gameShortName) {
        super(chatId);
        addParameter("game_short_name", gameShortName);
    }
}