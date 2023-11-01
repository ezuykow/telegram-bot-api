package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a <a href="https://core.telegram.org/bots/api#games">Game</a>
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultGame extends InlineQueryResult<InlineQueryResultGame> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "game";

    /**
     * Short name of the game
     */
    @SerializedName("game_short_name")
    private String gameShortName;

    public InlineQueryResultGame(String id, String gameShortName) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.gameShortName = gameShortName;
    }
}