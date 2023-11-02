package kz.pandev.legrambotapi.models.types.games;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents one row of the high scores table for a game.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GameHighScore implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Position in high score table for the game
     */
    @SerializedName("position")
    private Integer position;

    /**
     * User
     */
    @SerializedName("user")
    private User user;

    /**
     * Position in high score table for the game
     */
    @SerializedName("score")
    private Integer score;
}