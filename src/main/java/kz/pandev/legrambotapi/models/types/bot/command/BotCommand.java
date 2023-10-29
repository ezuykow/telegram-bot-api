package kz.pandev.legrambotapi.models.types.bot.command;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a bot command.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BotCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Text of the command; 1-32 characters. Can contain only lowercase
     * English letters, digits and underscores.
     */
    @SerializedName("command")
    private String command;

    /**
     * Description of the command; 1-256 characters.
     */
    @SerializedName("description")
    private String description;
}