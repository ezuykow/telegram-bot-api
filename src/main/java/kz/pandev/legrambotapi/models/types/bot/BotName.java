package kz.pandev.legrambotapi.models.types.bot;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents the bot's name.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BotName implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The bot's name
     */
    @SerializedName("name")
    private String name;
}