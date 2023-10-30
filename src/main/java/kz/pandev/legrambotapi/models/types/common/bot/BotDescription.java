package kz.pandev.legrambotapi.models.types.common.bot;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents the bot's description.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BotDescription implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The bot's description
     */
    @SerializedName("description")
    private String description;
}