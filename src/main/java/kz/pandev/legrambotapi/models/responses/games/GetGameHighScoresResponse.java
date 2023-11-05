package kz.pandev.legrambotapi.models.responses.games;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.games.GameHighScore;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * Telegram bot API server response to GetGameHighScores request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetGameHighScoresResponse extends Response {

    /**
     * Result as {@link List} of {@link GameHighScore}
     */
    @SerializedName("result")
    private List<GameHighScore> gameHighScores;
}